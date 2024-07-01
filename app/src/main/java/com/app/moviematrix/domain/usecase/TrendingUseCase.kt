package com.app.moviematrix.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.moviematrix.data.local.database.MoviesDatabase
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.paging.TrendingMoviePagingSource
import com.app.moviematrix.data.paging.TrendingPersonPagingSource
import com.app.moviematrix.data.paging.TrendingTvShowPagingSource
import com.app.moviematrix.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrendingUseCase
@Inject
constructor(
    private val repository: TrendingRepository,
    private val trendingTvShowPagingSource: TrendingTvShowPagingSource,
    private val moviesDatabase: MoviesDatabase
) {

    @OptIn(ExperimentalPagingApi::class)
    fun getTrendingPerson(): Flow<PagingData<Result>> {

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 10,
                initialLoadSize = 20
            ),
            pagingSourceFactory = {
                //moviesDatabase.getMoviesDao().getMovies()
                moviesDatabase.getMoviesDao().getMoviesByType("person")
            },
            remoteMediator = TrendingPersonPagingSource(
                repository = repository,
                moviesDatabase = moviesDatabase
            )
        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    fun getTrendingMovies(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 10,
                initialLoadSize = 20
            ),
            pagingSourceFactory = {
                //moviesDatabase.getMoviesDao().getMovies()
                moviesDatabase.getMoviesDao().getMoviesByType("movie")
            },
            remoteMediator = TrendingMoviePagingSource(
                repository = repository,
                moviesDatabase = moviesDatabase
            )
        ).flow
    }

    fun getTrendingTvShow(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(20, enablePlaceholders = true)
        ) {
            trendingTvShowPagingSource
        }.flow
    }
}
