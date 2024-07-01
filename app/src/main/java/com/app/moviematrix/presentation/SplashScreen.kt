package com.app.moviematrix.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.app.moviematrix.R
import com.app.moviematrix.navigation.DASHBOARD
import com.app.moviematrix.navigation.SPLASH
import com.app.moviematrix.presentation.ui.theme.Background
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(DASHBOARD) {
            popUpTo(SPLASH) { inclusive = true }
        }
    }
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = Background),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.Asset("loading.json"))

            LottieAnimation(
                modifier = Modifier.width(100.dp).height(100.dp),
                composition = rawComposition,
            )

            Text(
                text = "Movie Matrix",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
            )
        }
    }
}

@Composable
fun SplashAnimation() {

}
