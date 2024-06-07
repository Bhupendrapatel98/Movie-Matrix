package com.app.moviematrix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.moviematrix.data.model.trendingperson.TrendingPerson
import com.app.moviematrix.domain.use_case.TrendingPersonUseCase
import com.app.moviematrix.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingPersonViewModel @Inject constructor(private val trendingPersonUseCase: TrendingPersonUseCase): ViewModel(){

    private var trendingPersonMutableStateFlow = MutableStateFlow<Resource<TrendingPerson>>(Resource.loading())
    val trendingPersonStateFlow : StateFlow<Resource<TrendingPerson>> = trendingPersonMutableStateFlow

    fun getTrendingPerson(apiKey:String){
        viewModelScope.launch {
            trendingPersonUseCase.invoke(apiKey).collect{
                trendingPersonMutableStateFlow.value = it
            }
        }
    }
}