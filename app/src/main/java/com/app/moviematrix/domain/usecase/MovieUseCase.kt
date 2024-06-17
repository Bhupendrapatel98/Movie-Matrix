package com.app.moviematrix.domain.usecase

import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.domain.repository.MovieRepository
import com.app.moviematrix.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend fun getUpComingMovie(apiKey: String): Flow<Resource<TrendingResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(movieRepository.getUpComingMovies(apiKey)))
    }.catch { e ->
        emit(Resource.failed(e.message.toString()))
    }

    suspend fun getPopularMovie(apiKey: String): Flow<Resource<TrendingResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(movieRepository.getPopularMovies(apiKey)))
    }.catch { e ->
        emit(Resource.failed(e.message.toString()))
    }
}