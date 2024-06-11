package com.app.moviematrix.presentation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.moviematrix.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun MyList(context: Context) {
    TabLayout(context)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(context: Context) {
    val titles = listOf("Movie", "Tv Show")
    var tabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color(context.getColor(R.color.background)),
            contentColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                )
            },
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title) },
                    selected = tabIndex == index,
                    onClick = {
                        tabIndex = index
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    },
                )
            }
        }
        HorizontalPager(
            count = titles.size,
            state = pagerState,
        ) { tabIndex ->
            when (tabIndex) {
                0 -> MovieTab(context)
                1 -> TvShowTab(context)
            }
        }

        // Sync the tabIndex with pagerState
        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                tabIndex = page
            }
        }
    }
}

@Composable
fun MovieTab(context: Context) {
    Text(
        text = "Movies Content",
        color = Color.White,
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color(context.getColor(R.color.background)))
                .padding(16.dp),
    )
}

@Composable
fun TvShowTab(context: Context) {
    Text(
        text = "TV Shows Content",
        color = Color.White,
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color(context.getColor(R.color.background)))
                .padding(16.dp),
    )
}
