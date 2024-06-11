package com.app.moviematrix.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.moviematrix.presentation.MainScreen
import com.app.moviematrix.presentation.MovieList
import com.app.moviematrix.presentation.PersonList
import com.app.moviematrix.presentation.SplashScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    context: Context,
) {
    NavHost(navController = navHostController, startDestination = SPLASH) {
        composable(route = SPLASH) {
            SplashScreen(navHostController)
        }
        composable(route = DASHBOARD) {
            // AppBottomNavigation(navHostController,context)
            MainScreen(navHostController, context)
        }
        composable(route = MOVIE_LIST) {
            MovieList(context = context)
        }
        composable(route = PERSON_LIST) {
            PersonList(context = context)
        }
    }
}
