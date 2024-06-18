package com.app.moviematrix.domain.usecase

import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.domain.repository.TrendingRepository
import com.app.moviematrix.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import java.io.IOException
import javax.inject.Inject

class TrendingUseCase
@Inject
constructor(private val repository: TrendingRepository) {
    fun getTrendingPerson(apiKey: String): Flow<Resource<TrendingResponse>> =
        flow {
            emit(Resource.loading())
            emit(Resource.success(repository.getTrendingPerson(apiKey)))
        }.retry(1) { e ->
            e is IOException
        }.catch {
            emit(Resource.failed(it.message.toString()))
        }

    fun getTrendingMovies(apiKey: String): Flow<Resource<TrendingResponse>> =
        flow {
            emit(Resource.loading())
            emit(Resource.success(repository.getTrendingMovie(apiKey)))
        }.retry(1) { e ->
            e is IOException
        }.catch {
            emit(Resource.failed(it.message.toString()))
        }

    fun getTrendingTvShow(apiKey: String): Flow<Resource<TrendingResponse>> =
        flow {
            emit(Resource.loading())
            emit(Resource.success(repository.getTrendingTvShow(apiKey)))
        }.retry(1) { e ->
            e is IOException
        }.catch {
            emit(Resource.failed(it.message.toString()))
        }
}
