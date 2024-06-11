package com.app.moviematrix.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.moviematrix.R

@Preview
@Composable
fun SearchPage() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 15.dp),
    ) {
        Column {
            Text(
                text = "Discover",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            )
            Box(
                Modifier
                    .padding(top = 20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(horizontal = 35.dp, vertical = 10.dp)
                    .align(Alignment.CenterHorizontally),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        Icons.Default.Search,
                        contentDescription = "searchImage",
                        colorFilter =
                            ColorFilter.tint(
                                Color.Gray,
                            ),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Movie, Tv Show or Person",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                    )
                }
            }

            Text(
                text = "Recommended",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 35.dp),
            )

            Box(Modifier.padding(top = 15.dp)) {
                Row {
                    Box(
                        Modifier
                            .weight(1f)
                            .height(120.dp)
                            .clip(RoundedCornerShape(15.dp)),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = "person",
                            contentScale = ContentScale.Crop,
                            modifier =
                                Modifier
                                    .fillMaxHeight(),
                        )
                        Box(
                            modifier =
                                Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .background(Color.Black.copy(alpha = 0.4f)),
                        )
                        Text(
                            text = "Movies",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier =
                                Modifier
                                    .padding(top = 25.dp)
                                    .align(alignment = Alignment.BottomCenter),
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Box(
                        Modifier
                            .weight(1f)
                            .height(120.dp)
                            .clip(RoundedCornerShape(15.dp)),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = "person",
                            contentScale = ContentScale.Crop,
                            modifier =
                                Modifier
                                    .fillMaxHeight(),
                        )

                        Box(
                            modifier =
                                Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .background(Color.Black.copy(alpha = 0.4f)),
                        )

                        Text(
                            text = "Tv Shows",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier =
                                Modifier
                                    .padding(top = 25.dp)
                                    .align(alignment = Alignment.BottomCenter),
                        )
                    }
                }
            }

            Box(
                Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(15.dp)),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "person",
                    contentScale = ContentScale.Crop,
                )

                Box(
                    modifier =
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Color.Black.copy(alpha = 0.4f)),
                )

                Text(
                    text = "Persons",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier =
                        Modifier
                            .padding(top = 25.dp)
                            .align(alignment = Alignment.BottomCenter),
                )
            }
        }
    }
}
