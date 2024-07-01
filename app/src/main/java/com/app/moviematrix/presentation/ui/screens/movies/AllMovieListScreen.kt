package com.app.moviematrix.presentation.ui.screens.movies

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.app.moviematrix.R
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.presentation.MoviesViewModel
import com.app.moviematrix.presentation.TrendingViewModel

@Composable
fun MovieList(
    context: Context, type: String?,viewModel: TrendingViewModel = hiltViewModel(),
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {
    val trendingMoviesData: LazyPagingItems<Result> =
        if (type.equals("TrendingMovies", ignoreCase = true)) {
            viewModel.trendingMoviesStateFlow.collectAsLazyPagingItems()
        } else if (type.equals("TrendingTv Show", ignoreCase = true)) {
            viewModel.trendingTvShowStateFlow.collectAsLazyPagingItems()
        } else {
            moviesViewModel.popularMovieStateFlow.collectAsLazyPagingItems()
        }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(
                    ContextCompat.getColor(
                        context,
                        R.color.background
                    )
                )
            )
    ) {
        Text(
            text = "Movie Matrix",
            fontSize = 20.sp,
            color = Color.White,
            modifier =
            Modifier
                .padding(vertical = 10.dp, horizontal = 15.dp)
        )
        LazyColumn {
            items(trendingMoviesData.itemCount) { index ->
                val response = trendingMoviesData[index]
                if (response != null) {
                    AllMovieListItem(response)
                }
            }
        }
    }

    trendingMoviesData.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {

            }

            loadState.refresh is LoadState.NotLoading -> {

            }
        }

    }

}

@Composable
fun AllMovieListItem(result: Result) {
    Row(
        Modifier
            .height(140.dp)
            .padding(horizontal = 15.dp),
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w185" + result.poster_path),
            contentDescription = "bannerImage",
            modifier =
            Modifier
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
        )
        Column(Modifier.padding(start = 10.dp)) {
            Text(text = (result.release_date?:result.first_air_date).toString(), color = Color.White, fontSize = 14.sp)
            Text(
                text = (result.original_title ?: result.original_name).toString(),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp),
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    Icons.Default.Star,
                    contentDescription = "start",
                    colorFilter =
                    ColorFilter.tint(
                        Color.White,
                    ),
                    modifier = Modifier.size(16.dp),
                )
                Text(text = result.vote_average.toString(), color = Color.White, fontSize = 16.sp)
            }
        }
    }
    HorizontalDivider(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .height(1.dp)
            .background(Color.White),
    )
}
