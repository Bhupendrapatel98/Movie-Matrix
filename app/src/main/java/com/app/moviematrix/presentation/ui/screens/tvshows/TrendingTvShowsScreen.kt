package com.app.moviematrix.presentation.ui.screens.tvshows

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.moviematrix.presentation.TrendingViewModel
import com.app.moviematrix.presentation.ui.components.CommonListUI
import com.app.moviematrix.utills.Resource

@Composable
fun TrendingTvShow(navigationController: NavController, viewModel: TrendingViewModel) {
    val trendingTvShow = viewModel.trendingTvShowStateFlow.collectAsLazyPagingItems()
    trendingTvShow.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {

            }
            loadState.refresh is LoadState.NotLoading->{
                CommonListUI("Trending", "Tv Show", navigationController, trendingTvShow)
            }
        }
    }
}