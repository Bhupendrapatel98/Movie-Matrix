package com.app.moviematrix.data.remote.repository

import com.app.moviematrix.data.model.trendingperson.TrendingPerson
import com.app.moviematrix.data.remote.api.ApiService
import com.app.moviematrix.domain.repository.TrendingPersonRepository
import javax.inject.Inject

class TrendingPersonRepositoryImpl @Inject constructor(private val apiService: ApiService): TrendingPersonRepository {
    override suspend fun getTrendingPerson(apikey: String): TrendingPerson {
        return apiService.getTrendingPerson(apikey)
    }
}