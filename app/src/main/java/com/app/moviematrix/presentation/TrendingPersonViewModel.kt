package com.app.moviematrix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.moviematrix.BuildConfig
import com.app.moviematrix.data.model.trendingperson.TrendingPerson
import com.app.moviematrix.domain.usecase.TrendingPersonUseCase
import com.app.moviematrix.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingPersonViewModel
    @Inject
    constructor(private val trendingPersonUseCase: TrendingPersonUseCase) : ViewModel() {
        private var trendingPersonMutableStateFlow = MutableStateFlow<Resource<TrendingPerson>>(Resource.loading())
        val trendingPersonStateFlow: StateFlow<Resource<TrendingPerson>> = trendingPersonMutableStateFlow

        init {
            getTrendingPerson(BuildConfig.API_KEY)
        }

        fun getTrendingPerson(apiKey: String) {
            viewModelScope.launch {
                trendingPersonUseCase.invoke(apiKey).collect {
                    trendingPersonMutableStateFlow.value = it
                }
            }
        }
    }