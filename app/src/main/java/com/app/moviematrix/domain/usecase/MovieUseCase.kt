package com.app.moviematrix.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.data.paging.PopularMoviePagingSource
import com.app.moviematrix.domain.repository.MovieRepository
import com.app.moviematrix.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val popularMoviePagingSource: PopularMoviePagingSource
) {
    suspend fun getUpComingMovie(apiKey: String): Flow<Resource<TrendingResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(movieRepository.getUpComingMovies(apiKey)))
    }.catch { e ->
        emit(Resource.failed(e.message.toString()))
    }

    fun getPopularMovie(apiKey: String): Flow<PagingData<Result>> {
        return Pager(config = PagingConfig(10, enablePlaceholders = true)) {
            popularMoviePagingSource
        }.flow
    }
}