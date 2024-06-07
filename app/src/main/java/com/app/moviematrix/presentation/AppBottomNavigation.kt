package com.app.moviematrix.presentation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.app.moviematrix.R

@Composable
fun AppBottomNavigation(navController: NavController, context: Context) {
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(bottomBar = {
        BottomNavigation(
            backgroundColor = Color(
                ContextCompat.getColor(
                    context,
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
                .background(
                    Color(
                        ContextCompat.getColor(
                            context,
                            R.color.background
                        )
                    )
                )
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            when (selectedItem) {
                0 -> Home(navController)
                1 -> SearchPage()
                2 -> MyList(context)
                3 -> MenuPage()
            }
        }

    }
}