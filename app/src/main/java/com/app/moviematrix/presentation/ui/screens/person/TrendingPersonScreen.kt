package com.app.moviematrix.presentation.ui.screens.person

import android.content.Context
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.moviematrix.navigation.PERSON_LIST
import com.app.moviematrix.presentation.TrendingViewModel
import com.app.moviematrix.presentation.ui.components.TrendingPersonList
import kotlin.math.min

@Composable
fun getTrendingPersonData(
    navigationController: NavController,
    viewModel: TrendingViewModel,
    context: Context,
) {
    val trendingPersonData = viewModel.trendingPersonStateFlow.collectAsLazyPagingItems()

    Row(
        modifier = Modifier.padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Trending",
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Person", color = Color.Gray, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        // Text(text = "More", color = Color.Red, fontSize = 16.sp)
        ClickableText(
            text = AnnotatedString("More"),
            style = TextStyle(color = Color.Red, fontSize = 16.sp),
            onClick = {
                navigationController.navigate(PERSON_LIST)
            },
        )
    }

    trendingPersonData.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                Text(text = "Error")
            }

            loadState.refresh is LoadState.NotLoading -> {
                LazyRow {
                    items(min(trendingPersonData.itemCount, 5)) { index ->
                        val repository = trendingPersonData[index]
                        if (repository != null) {
                            TrendingPersonList(navigationController, repository)
                        }
                    }
                }
            }
        }
    }
}
