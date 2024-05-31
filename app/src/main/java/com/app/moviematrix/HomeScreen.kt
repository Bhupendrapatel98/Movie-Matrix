package com.app.moviematrix

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat

@Preview(showBackground = true)
@Composable
fun TrendingPersonList() {
    val itemList = listOf("bhupendra", "Ankit", "yogesh", "Adil", "shefali", "Bandana")
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

@Preview
@Composable
fun TrendingMovies() {
    val list = listOf("Ankit", "Bhupendra", "shefali", "Pooja", "Mayank", "Yogesh")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Trending",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.width(5.dp))
            Text(text = "Movies", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "More", fontSize = 16.sp, color = Color.Red)
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

@Preview
@Composable
fun PopularMovies() {
    val list = listOf("Ankit", "Bhupendra", "shefali", "Pooja", "Mayank", "Yogesh")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Popular",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.width(5.dp))
            Text(text = "Movies", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "More", fontSize = 16.sp, color = Color.Red)
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

@Preview
@Composable
fun TopRatedTvShow() {
    val list = listOf("Ankit", "Bhupendra", "shefali", "Pooja", "Mayank", "Yogesh")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Top Rated",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.width(5.dp))
            Text(text = "Tv Show", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "More", fontSize = 16.sp, color = Color.Red)
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