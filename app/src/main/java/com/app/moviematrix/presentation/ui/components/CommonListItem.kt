package com.app.moviematrix.presentation.ui.components

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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.navigation.MOVIE_LIST
import kotlin.math.min

@Composable
fun CommonListUI(
    heading: String,
    title: String,
    navigationController: NavController,
    lazyPagingItems:LazyPagingItems<Result>
) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
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
                    navigationController.navigate("$MOVIE_LIST/$heading$title")
                },
            )
        }
        LazyRow(modifier = Modifier.padding(top = 15.dp)) {
            items(min(lazyPagingItems.itemCount,5) ) { index ->
                val item = lazyPagingItems[index]
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(130.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Box {
                        Image(
                            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w185" + item!!.poster_path),
                            contentDescription = "banner Image",
                            contentScale = ContentScale.Crop,
                            modifier =
                            Modifier
                                .width(130.dp)
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
                        text = (item?.original_title ?: item?.original_name).toString(),
                        fontSize = 14.sp,
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