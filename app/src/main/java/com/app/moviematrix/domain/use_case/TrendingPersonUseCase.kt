package com.app.moviematrix.domain.use_case

import com.app.moviematrix.data.model.trendingperson.TrendingPerson
import com.app.moviematrix.domain.repository.TrendingPersonRepository
import com.app.moviematrix.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingPersonUseCase @Inject constructor(private val repository: TrendingPersonRepository) {
    operator fun invoke(apiKey: String): Flow<Resource<TrendingPerson>> = flow {
        emit(Resource.loading())
        emit(Resource.success(repository.getTrendingPerson(apiKey)))
    }.catch {
        emit(Resource.failed(it.message.toString()))
    }
}