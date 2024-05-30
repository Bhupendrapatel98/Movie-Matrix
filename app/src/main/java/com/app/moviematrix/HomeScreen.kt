package com.app.moviematrix

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
                Text(text = item, color = Color.White)
            }
        }
    }
}