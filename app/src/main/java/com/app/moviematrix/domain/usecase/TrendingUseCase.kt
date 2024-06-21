package com.app.moviematrix.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.data.remote.repository.TrendingPersonPagingSource
import com.app.moviematrix.domain.repository.TrendingRepository
import com.app.moviematrix.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import java.io.IOException
import javax.inject.Inject

class TrendingUseCase
@Inject
constructor(
    private val repository: TrendingRepository,
    private val trendingPersonPagingSource: TrendingPersonPagingSource
) {
//    fun getTrendingPerson(page:Int): Flow<Resource<TrendingResponse>> =
//        flow {
//            emit(Resource.loading())
//            emit(Resource.success(repository.getTrendingPerson(page)))
//        }.retry(1) { e ->
//            e is IOException
//        }.catch {
//            emit(Resource.failed(it.message.toString()))
//        }

    fun getTrendingPerson(): Flow<PagingData<Result>> {

        return Pager(
            config = PagingConfig(20, enablePlaceholders = true)
        ) {
            trendingPersonPagingSource
        }.flow
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
