package com.app.moviematrix.data.remote.repository

import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.data.remote.api.ApiService
import com.app.moviematrix.domain.repository.TrendingRepository
import javax.inject.Inject

class TrendingRepositoryImpl
@Inject
constructor(private val apiService: ApiService) : TrendingRepository {
    override suspend fun getTrendingPerson(page: Int): TrendingResponse {
        return apiService.getTrendingPerson(page)
    }

    override suspend fun getTrendingMovie(page: Int): TrendingResponse {
        return apiService.getTrendingMovie(page)
    }

    override suspend fun getTrendingTvShow(page:Int): TrendingResponse {
        return apiService.getTrendingTvShow(page)
    }
}
