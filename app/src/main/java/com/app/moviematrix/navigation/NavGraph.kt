package com.app.moviematrix.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.moviematrix.AppBottomNavigation
import com.app.moviematrix.MovieList
import com.app.moviematrix.PersonList

@Composable
fun NavGraph(navHostController: NavHostController, context: Context) {
    NavHost(navController = navHostController, startDestination = MainDestinations.HOME_ROUTE) {
        composable(route = MainDestinations.HOME_ROUTE) {
            AppBottomNavigation(navHostController,context)
        }
        composable(route = MainDestinations.MOVIE_LIST) {
            MovieList(context = context)
        }
        composable(route = MainDestinations.PERSON_LIST) {
            PersonList(context = context)
        }
    }
}


