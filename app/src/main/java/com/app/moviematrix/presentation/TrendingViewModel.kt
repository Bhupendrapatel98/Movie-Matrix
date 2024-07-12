package com.app.moviematrix.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.moviematrix.BuildConfig
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.domain.usecase.TrendingUseCase
import com.app.moviematrix.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel
@Inject
constructor(private val trendingUseCase: TrendingUseCase,
           @ViewModelScoped private val viewModelScope: CoroutineScope
) : ViewModel() {

    private var trendingPersonMutableStateFlow = MutableStateFlow<PagingData<Result>>(PagingData.empty())
    val trendingPersonStateFlow: StateFlow<PagingData<Result>> = trendingPersonMutableStateFlow

    private var trendingMoviesMutableStateFlow = MutableStateFlow<PagingData<Result>>(PagingData.empty())
    val trendingMoviesStateFlow: StateFlow<PagingData<Result>> = trendingMoviesMutableStateFlow

    private var trendingTvShowMutableStateFlow = MutableStateFlow<PagingData<Result>>(PagingData.empty())
    val trendingTvShowStateFlow: StateFlow<PagingData<Result>> = trendingTvShowMutableStateFlow

    init {
        getTrending()
    }

    fun getTrending() {
        viewModelScope.launch {

            launch {
                trendingUseCase.getTrendingPerson().cachedIn(viewModelScope).collect {
                    trendingPersonMutableStateFlow.value = it
                }
            }

            launch {
                trendingUseCase.getTrendingMovies().cachedIn(viewModelScope).collect {
                    trendingMoviesMutableStateFlow.value = it
                }
            }

            launch {
                trendingUseCase.getTrendingTvShow().cachedIn(viewModelScope).collect {
                    trendingTvShowMutableStateFlow.value = it
                }
            }
        }
    }

}
