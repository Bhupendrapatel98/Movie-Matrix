package com.app.moviematrix.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.app.moviematrix.R
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.navigation.MOVIE_LIST
import com.app.moviematrix.navigation.PERSON_LIST
import com.app.moviematrix.utills.Resource

@Composable
fun Home(
    navigationController: NavController,
    context: Context,
    viewModel: TrendingViewModel = hiltViewModel(),
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {
    Column {
        Header()
        Column(
            modifier =
            Modifier
                .padding(horizontal = 15.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            SliderBanner(moviesViewModel)
            Spacer(modifier = Modifier.height(10.dp))
            getTrendingPersonData(
                navigationController = navigationController,
                viewModel,
                context = context
            )
            TrendingMovies(navigationController, viewModel)
            TrendingTvShow(navigationController, viewModel)
            PopularMovies(navigationController, moviesViewModel)
        }
    }
}

@Composable
fun getTrendingPersonData(
    navigationController: NavController,
    viewModel: TrendingViewModel,
    context: Context,
) {
    val trendingPersonState by viewModel.trendingPersonStateFlow.collectAsState()

    when (val state = trendingPersonState) {
        is Resource.Loading -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                CircularProgressIndicator()
            }
        }

        is Resource.Success -> {
            TrendingPersonList(navigationController, state.data.results)
        }

        is Resource.Failed -> {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun TrendingPersonList(
    navigationController: NavController,
    list: List<Result>,
) {
    Row(
        modifier = Modifier.padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Trending",
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Person", color = Color.Gray, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        // Text(text = "More", color = Color.Red, fontSize = 16.sp)
        ClickableText(
            text = AnnotatedString("More"),
            style = TextStyle(color = Color.Red, fontSize = 16.sp),
            onClick = {
                navigationController.navigate(PERSON_LIST)
            },
        )
    }
    LazyRow {
        items(list) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .width(90.dp),
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        "https://image.tmdb.org/t/p/w185" + item.profile_path,
                        placeholder = painterResource(id = R.drawable.imageplaceholder),
                        error = painterResource(id = R.drawable.imageplaceholder)
                    ),
                    contentDescription = "Person Image",
                    contentScale = ContentScale.Crop,
                    modifier =
                    Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .clip(CircleShape),
                )
                Text(
                    text = item.name, color = Color.White, modifier = Modifier.padding(top = 8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Movie Stack",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            Icons.Rounded.Search,
            contentDescription = "Search",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier.size(32.dp),
        )
    }
}

@Composable
fun TrendingMovies(navigationController: NavController, viewModel: TrendingViewModel) {

    val trendingMovieState by viewModel.trendingMoviesStateFlow.collectAsState()

    when (val state = trendingMovieState) {
        is Resource.Loading -> {
            CircularProgressIndicator()
        }

        is Resource.Success -> {
            CommonListUI("Trending", "Movies", navigationController, state.data.results)
        }

        is Resource.Failed -> {}
    }
}

@Composable
fun PopularMovies(navigationController: NavController, viewModel: MoviesViewModel) {
    val popularMovieState by viewModel.popularMovieStateFlow.collectAsState()
    when (val state = popularMovieState) {
        is Resource.Loading -> {
            CircularProgressIndicator()
        }

        is Resource.Success -> {
            CommonListUI("Popular", "Movies", navigationController, state.data.results)
        }

        is Resource.Failed -> {}
    }
}

@Composable
fun TrendingTvShow(navigationController: NavController, viewModel: TrendingViewModel) {
    val trendingTvShow by viewModel.trendingTvShowStateFlow.collectAsState()
    when (val state = trendingTvShow) {
        is Resource.Loading -> {
            CircularProgressIndicator()
        }

        is Resource.Success -> {
            CommonListUI("Trending", "Tv Show", navigationController, state.data.results)
        }

        is Resource.Failed -> {}
    }
}

@Composable
fun CommonListUI(
    heading: String,
    title: String,
    navigationController: NavController,
    list: List<Result>
) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(top = 18.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = heading,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            Spacer(Modifier.width(5.dp))
            Text(text = title, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            // Text(text = "More", fontSize = 16.sp, color = Color.Red)
            ClickableText(
                text = AnnotatedString("More"),
                style = TextStyle(color = Color.Red, fontSize = 16.sp),
                onClick = {
                    navigationController.navigate(MOVIE_LIST)
                },
            )
        }
        LazyRow(modifier = Modifier.padding(top = 15.dp)) {
            items(list) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(120.dp)
                ) {
                    Box {
                        Image(
                            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w185" + item.poster_path),
                            contentDescription = "banner Image",
                            contentScale = ContentScale.Crop,
                            modifier =
                            Modifier
                                .width(120.dp)
                                .height(150.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .padding(horizontal = 5.dp),
                        )
                        Text(
                            text = item.vote_average.toString(),
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier =
                            Modifier
                                .padding(top = 5.dp, end = 8.dp)
                                .clip(
                                    CircleShape,
                                )
                                .background(Color.Black)
                                .padding(horizontal = 10.dp)
                                .align(alignment = Alignment.TopEnd),
                        )
                    }
                    Text(
                        text = item.original_title ?: item.original_name,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                        modifier = Modifier.padding(top = 8.dp),
                    )
                }
            }
        }
    }
}
