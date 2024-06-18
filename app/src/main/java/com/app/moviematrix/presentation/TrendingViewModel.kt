package com.app.moviematrix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.moviematrix.BuildConfig
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.domain.usecase.TrendingUseCase
import com.app.moviematrix.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel
@Inject
constructor(private val trendingUseCase: TrendingUseCase) : ViewModel() {

    private var trendingPersonMutableStateFlow = MutableStateFlow<Resource<TrendingResponse>>(Resource.loading())
    val trendingPersonStateFlow: StateFlow<Resource<TrendingResponse>> = trendingPersonMutableStateFlow

    private var trendingMoviesMutableStateFlow = MutableStateFlow<Resource<TrendingResponse>>(Resource.loading())
    val trendingMoviesStateFlow: StateFlow<Resource<TrendingResponse>> = trendingMoviesMutableStateFlow

    private var trendingTvShowMutableStateFlow = MutableStateFlow<Resource<TrendingResponse>>(Resource.loading())
    val trendingTvShowStateFlow: StateFlow<Resource<TrendingResponse>> = trendingTvShowMutableStateFlow

    init {
        getTrending(BuildConfig.API_KEY)
    }

    fun getTrending(apiKey: String) {
        viewModelScope.launch {
            launch {
                trendingUseCase.getTrendingPerson(apiKey).collect {
                    trendingPersonMutableStateFlow.value = it
                }
            }

            launch {
                trendingUseCase.getTrendingMovies(apiKey).collect {
                    trendingMoviesMutableStateFlow.value = it
                }
            }

            launch {
                trendingUseCase.getTrendingTvShow(apiKey).collect {
                    trendingTvShowMutableStateFlow.value = it
                }
            }
        }
    }
}
