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

    init {
        getTrending(BuildConfig.API_KEY)
    }

    fun getTrending(apiKey: String) {
        viewModelScope.launch {
            trendingUseCase.getTrendingPerson(apiKey).collect {
                trendingPersonMutableStateFlow.value = it
            }
            trendingUseCase.getTrendingMovies(apiKey).collect {
                trendingMoviesMutableStateFlow.value = it
            }
        }
    }
}
