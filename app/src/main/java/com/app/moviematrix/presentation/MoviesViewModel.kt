package com.app.moviematrix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.app.moviematrix.BuildConfig
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.domain.usecase.MovieUseCase
import com.app.moviematrix.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    private var upcomingMovieMutableStateFlow =
        MutableStateFlow<Resource<TrendingResponse>>(Resource.loading())
    val upcomingMovieStateFlow: StateFlow<Resource<TrendingResponse>> =
        upcomingMovieMutableStateFlow

    private var popularMovieMutableStateFlow = MutableStateFlow<PagingData<Result>>(PagingData.empty())
    val popularMovieStateFlow: StateFlow<PagingData<Result>> = popularMovieMutableStateFlow

    init {
        getMovieData(BuildConfig.API_KEY)
    }

    fun getMovieData(apiKey: String) {
        viewModelScope.launch {
            movieUseCase.getUpComingMovie(apiKey).collect {
                upcomingMovieMutableStateFlow.value = it
            }
            movieUseCase.getPopularMovie(apiKey).collect {
                popularMovieMutableStateFlow.value = it
            }
        }
    }
}