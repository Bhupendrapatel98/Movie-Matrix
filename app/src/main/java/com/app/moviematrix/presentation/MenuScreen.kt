package com.app.moviematrix.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.moviematrix.R

@Composable
fun MenuPage() {
    Column(Modifier.padding(top = 25.dp, start = 15.dp, end = 15.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = "BookMark",
                modifier = Modifier.size(30.dp),
            )
            Text(
                text = "BookMarks",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
            )
        }
        HorizontalDivider(
            color = Color.White,
            modifier =
                Modifier
                    .padding(vertical = 15.dp)
                    .height(1.dp)
                    .fillMaxWidth(),
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_rate),
                contentDescription = "Rate",
                modifier = Modifier.size(30.dp),
            )
            Text(
                text = "Rate",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
            )
        }
        HorizontalDivider(
            color = Color.White,
            modifier =
                Modifier
                    .padding(vertical = 15.dp)
                    .height(1.dp)
                    .fillMaxWidth(),
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                Icons.Default.Share,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "Share",
                modifier = Modifier.size(30.dp),
            )
            Text(
                text = "Share",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
            )
        }
        HorizontalDivider(
            color = Color.White,
            modifier =
                Modifier
                    .padding(vertical = 15.dp)
                    .height(1.dp)
                    .fillMaxWidth(),
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                Icons.Default.Info,
                contentDescription = "BookMark",
                modifier = Modifier.size(30.dp),
                colorFilter = ColorFilter.tint(Color.White),
            )
            Text(
                text = "App Info",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
            )
        }
        HorizontalDivider(
            color = Color.White,
            modifier =
                Modifier
                    .padding(vertical = 15.dp)
                    .height(1.dp)
                    .fillMaxWidth(),
        )
    }
}
