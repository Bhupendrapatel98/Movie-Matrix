package com.app.moviematrix.presentation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.moviematrix.R
import com.app.moviematrix.navigation.MainDestinations
import com.app.moviematrix.ui.theme.Background

@Composable
fun MainScreen(navController: NavController, context: Context) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { AppBottomNavigation(bottomNavController, context) }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Background)) {
            NavHost(
                navController = bottomNavController,
                startDestination = Screen.Home.route
            ) {
                composable(Screen.Home.route) { Home(navigationController = navController,context) }
                composable(Screen.Search.route) { SearchPage() }
                composable(Screen.List.route) { MyList(context = context) }
                composable(Screen.Menu.route) { MenuPage() }
            }
        }
    }
}

@Composable
fun AppBottomNavigation(navController: NavController, context: Context) {

    val screens = listOf(
        Screen.Home,
        Screen.Search,
        Screen.List,
        Screen.Menu
    )
    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route

    BottomNavigation(
        contentColor = Color.White,
        backgroundColor = Color(
            ContextCompat.getColor(
                context,
                R.color.bottomnav
            )
        )
    ) {
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                label = { Text(text = screen.label, color = Color.White) },
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(screen.icon, contentDescription = null) }
            )
        }
    }

}

sealed class Screen(val route: String, val icon: ImageVector, val label: String) {
    object Home : Screen(MainDestinations.HOME, Icons.Default.Home, "Home")
    object Search : Screen(MainDestinations.SEARCH, Icons.Default.Search, "Search")
    object List : Screen(MainDestinations.LIST, Icons.Default.List, "List")
    object Menu : Screen(MainDestinations.MENU, Icons.Default.Menu, "Menu")
}