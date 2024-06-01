package com.app.moviematrix

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.app.moviematrix.ui.theme.MovieMatrixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.dark(
//                ContextCompat.getColor(applicationContext, R.color.background)
//            )
//        )

        //statusBarColor
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.background)

        setContent {
            BottomNavigation()
        }
    }

    @Composable
    fun BottomNavigation() {
        var selectedItem by remember { mutableStateOf(0) }

        Scaffold(bottomBar = {
            androidx.compose.material.BottomNavigation(
                backgroundColor = Color(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.bottomnav
                    )
                )
            ) {
                BottomNavigationItem(
                    selected = selectedItem == 0,
                    label = { Text(text = "Home", color = Color.White) },
                    onClick = { selectedItem = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = "", tint = Color.White) }
                )

                BottomNavigationItem(
                    selected = selectedItem == 1,
                    label = { Text(text = "Search", color = Color.White) },
                    onClick = { selectedItem = 1 },
                    icon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                )

                BottomNavigationItem(
                    selected = selectedItem == 2,
                    label = { Text(text = "List", color = Color.White) },
                    onClick = { selectedItem = 2 },
                    icon = { Icon(Icons.Default.List, contentDescription = "", tint = Color.White) }
                )

                BottomNavigationItem(
                    selected = selectedItem == 3,
                    label = { Text(text = "Menu", color = Color.White) },
                    onClick = { selectedItem = 3 },
                    icon = { Icon(Icons.Default.Menu, contentDescription = "", tint = Color.White) }
                )
            }
        }) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                when (selectedItem) {
                    0 -> Home()
                    1 -> Home()
                    2 -> Home()
                    3 -> Home()
                }
            }

        }
    }

    @Composable
    fun Home() {
        Column(
            modifier = Modifier
                .background(
                    Color(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.background
                        )
                    )
                )
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Header()
            SliderBanner()
            TrendingPersonList()
            TrendingMovies()
            PopularMovies()
            TopRatedTvShow()
        }
    }
}