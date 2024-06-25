package com.app.moviematrix.navigation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.app.moviematrix.presentation.ui.screens.bottomNavigation.MainScreen
import com.app.moviematrix.presentation.MovieList
import com.app.moviematrix.presentation.ui.screens.person.PersonList
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
        composable(
            route = "$MOVIE_LIST/{movieType}",
            arguments = listOf(navArgument("movieType") { type = NavType.StringType })
        ) {
            val movieType = it.arguments?.getString("movieType")
            Log.d("MovieType", "NavGraph: $movieType")
            MovieList(context = context)
        }
        composable(route = PERSON_LIST) {
            PersonList(context = context)
        }
    }
}
