package com.app.moviematrix.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.app.moviematrix.data.model.trending.Result

@Composable
fun TrendingPersonAllList(list: Result) {

    Row(
        Modifier
            .height(80.dp)
            .padding(horizontal = 15.dp),
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w185" + list.profile_path),
            contentDescription = "bannerImage",
            modifier =
            Modifier
                .width(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Column(
            Modifier
                .padding(start = 10.dp)
                .fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = list.name.toString(),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp),
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = list.known_for_department.toString(), color = Color.Gray, fontSize = 16.sp)
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