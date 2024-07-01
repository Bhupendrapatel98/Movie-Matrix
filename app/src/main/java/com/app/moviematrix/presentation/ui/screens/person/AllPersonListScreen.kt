package com.app.moviematrix.presentation.ui.screens.person

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.moviematrix.R
import com.app.moviematrix.presentation.TrendingViewModel
import com.app.moviematrix.presentation.ui.components.TrendingPersonAllList

@Composable
fun PersonList(context: Context, viewModel: TrendingViewModel = hiltViewModel()) {

    val trendingPersonData = viewModel.trendingPersonStateFlow.collectAsLazyPagingItems()

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(
                Color(
                    ContextCompat.getColor(
                        context,
                        R.color.background,
                    ),
                ),
            ),
    ) {
        Text(
            text = "Movie Matrix",
            fontSize = 20.sp,
            color = Color.White,
            modifier =
            Modifier
                .padding(vertical = 10.dp, horizontal = 15.dp)
        )

        LazyColumn {
            items(trendingPersonData.itemCount) { index ->
                val repository = trendingPersonData[index]
                if (repository != null) {
                    TrendingPersonAllList(repository)
                }
            }
        }
    }


    trendingPersonData.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {

            }

            loadState.refresh is LoadState.NotLoading -> {

            }
        }
    }
}

