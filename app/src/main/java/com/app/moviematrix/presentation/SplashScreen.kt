package com.app.moviematrix.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.app.moviematrix.navigation.MainDestinations
import com.app.moviematrix.ui.theme.Background
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(300)
        navController.navigate(MainDestinations.HOME_ROUTE){
            popUpTo(MainDestinations.SPLASH){inclusive=true}
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Background))
}