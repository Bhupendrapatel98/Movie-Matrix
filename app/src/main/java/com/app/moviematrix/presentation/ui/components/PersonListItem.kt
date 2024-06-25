package com.app.moviematrix.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.app.moviematrix.R
import com.app.moviematrix.data.model.trending.Result

@Composable
fun TrendingPersonList(
    navigationController: NavController,
    list: Result,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .width(90.dp),
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                "https://image.tmdb.org/t/p/w185" + list.profile_path,
                placeholder = painterResource(id = R.drawable.imageplaceholder2),
                error = painterResource(id = R.drawable.imageplaceholder2)
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
            text = list.name.toString(),
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}