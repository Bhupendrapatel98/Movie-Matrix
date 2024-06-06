package com.app.moviematrix

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.moviematrix.navigation.MainDestinations

@Composable
fun Home(navigationController: NavController) {
    Column {
        Header()
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            SliderBanner()
            TrendingPersonList()
            TrendingMovies(navigationController)
            PopularMovies(navigationController)
            TopRatedTvShow(navigationController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrendingPersonList() {
    val itemList = listOf("bhupendra", "Ankit", "yogesh", "Adil", "shefali", "Bandana")
    Row(
        modifier = Modifier.padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Trending",
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Person", color = Color.Gray, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "More", color = Color.Red, fontSize = 16.sp)
    }
    LazyRow {
        items(itemList) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Person Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .clip(CircleShape)
                )
                Text(text = item, color = Color.White, modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Movie Stack",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
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
fun TrendingMovies(navigationController: NavController) {
    CommonListUI("Trending", "Movies", navigationController)
}

@Composable
fun PopularMovies(navigationController: NavController) {
    CommonListUI("Popular", "Movies", navigationController)
}

@Composable
fun TopRatedTvShow(navigationController: NavController) {
    CommonListUI("Top Rated", "Tv Show", navigationController)
}

@Composable
fun CommonListUI(heading: String, title: String, navigationController: NavController) {
    val list = listOf("Ankit", "Bhupendra", "shefali", "Pooja", "Mayank", "Yogesh")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = heading,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.width(5.dp))
            Text(text = title, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            //Text(text = "More", fontSize = 16.sp, color = Color.Red)
            ClickableText(
                text = AnnotatedString("More"),
                style = TextStyle(color = Color.Red, fontSize = 16.sp),
                onClick = {
                    navigationController.navigate(MainDestinations.MOVIE_LIST)
                })
        }
        LazyRow(modifier = Modifier.padding(top = 15.dp)) {
            items(list) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = "banner Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .padding(horizontal = 5.dp)
                        )
                        Text(
                            text = "8.8",
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 5.dp, end = 8.dp)
                                .clip(
                                    CircleShape
                                )
                                .background(Color.Black)
                                .padding(horizontal = 10.dp)
                                .align(alignment = Alignment.TopEnd)
                        )
                    }
                    Text(
                        text = item,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}