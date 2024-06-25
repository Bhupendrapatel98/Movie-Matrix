package com.app.moviematrix.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.data.paging.TrendingMoviePagingSource
import com.app.moviematrix.data.paging.TrendingPersonPagingSource
import com.app.moviematrix.data.paging.TrendingTvShowPagingSource
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
constructor(
    private val repository: TrendingRepository,
    private val trendingPersonPagingSource: TrendingPersonPagingSource,
    private val trendingMoviePagingSource: TrendingMoviePagingSource,
    private val trendingTvShowPagingSource: TrendingTvShowPagingSource
) {

    fun getTrendingPerson(): Flow<PagingData<Result>> {

        return Pager(
            config = PagingConfig(20, enablePlaceholders = true)
        ) {
            trendingPersonPagingSource
        }.flow
    }

    fun getTrendingMovies(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(20, enablePlaceholders = true)
        ) {
            trendingMoviePagingSource
        }.flow
    }

    fun getTrendingTvShow(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(20, enablePlaceholders = true)
        ) {
            trendingTvShowPagingSource
        }.flow
    }
}
