package com.app.moviematrix.presentation.ui.screens.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.moviematrix.presentation.MoviesViewModel
import com.app.moviematrix.presentation.TrendingViewModel
import com.app.moviematrix.presentation.ui.screens.movies.PopularMovies
import com.app.moviematrix.presentation.ui.screens.movies.TrendingMovies
import com.app.moviematrix.presentation.ui.screens.person.getTrendingPersonData
import com.app.moviematrix.presentation.ui.screens.tvshows.TrendingTvShow

@Composable
fun Home(
    navigationController: NavController,
    context: Context,
    viewModel: TrendingViewModel = hiltViewModel(),
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {
    Column {
        Header()
        Column(
            modifier =
            Modifier
                .padding(horizontal = 15.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            SliderBanner(moviesViewModel)
            Spacer(modifier = Modifier.height(15.dp))
            getTrendingPersonData(
                navigationController = navigationController,
                viewModel,
                context = context
            )
            TrendingMovies(navigationController, viewModel)
            TrendingTvShow(navigationController, viewModel)
            PopularMovies(navigationController, moviesViewModel)
        }
    }
}


@Composable
fun Header() {
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Movie Matrix",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            Icons.Rounded.Search,
            contentDescription = "Search",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier.size(32.dp),
        )
    }
}


