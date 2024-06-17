package com.app.moviematrix.data.remote.repository

import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.data.remote.api.ApiService
import com.app.moviematrix.domain.repository.TrendingRepository
import javax.inject.Inject

class TrendingRepositoryImpl
@Inject
constructor(private val apiService: ApiService) : TrendingRepository {
    override suspend fun getTrendingPerson(apikey: String): TrendingResponse {
        return apiService.getTrendingPerson(apikey)
    }

    override suspend fun getTrendingMovie(apikey: String): TrendingResponse {
        return apiService.getTrendingMovie(apikey)
    }

    override suspend fun getTrendingTvShow(apikey: String): TrendingResponse {
        return apiService.getTrendingTvShow(apikey)
    }
}
