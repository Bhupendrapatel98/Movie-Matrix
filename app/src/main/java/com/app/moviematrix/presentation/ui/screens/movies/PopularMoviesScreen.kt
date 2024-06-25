package com.app.moviematrix.presentation.ui.screens.movies

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.moviematrix.presentation.MoviesViewModel
import com.app.moviematrix.presentation.ui.components.CommonListUI
import com.app.moviematrix.utills.Resource

@Composable
fun PopularMovies(navigationController: NavController, viewModel: MoviesViewModel) {
    val popularMovieState = viewModel.popularMovieStateFlow.collectAsLazyPagingItems()
    popularMovieState.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {

            }

            loadState.refresh is LoadState.NotLoading -> {
                CommonListUI("Popular", "Movies", navigationController, popularMovieState)
            }
        }
    }
}