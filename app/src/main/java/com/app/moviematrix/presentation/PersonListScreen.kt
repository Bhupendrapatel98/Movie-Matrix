package com.app.moviematrix.presentation

import android.content.Context
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.app.moviematrix.R

@Composable
fun PersonList(context: Context) {
    Column(
        modifier = Modifier.fillMaxSize().background(
            Color(
                ContextCompat.getColor(
                    context,
                    R.color.background
                )
            )
        )
    ) {
        Text(
            text = "Movie Stack",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .background(Color(ContextCompat.getColor(context, R.color.bottomnav)))
        )
        val list = listOf("Bhupendra", "Nagendra", "Ankit", "Shubham", "ananya", "pandy")
        LazyColumn {
            items(list) { items ->
                Row(
                    Modifier
                        .height(80.dp)
                        .padding(horizontal = 15.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "bannerImage",
                        modifier = Modifier
                            .width(80.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Column(Modifier.padding(start = 10.dp).fillMaxSize(), verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "Bhupendra Patel",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Acting", color = Color.Gray, fontSize = 16.sp)

                    }

                }
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 15.dp)
                        .height(1.dp)
                        .background(Color.White)
                )

            }
        }
    }
}