package com.app.moviematrix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.app.moviematrix.R
import com.app.moviematrix.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //statusBarColor
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.background)

        setContent {
            val navController = rememberNavController()
            NavGraph(navHostController = navController,this)
        }
    }
}