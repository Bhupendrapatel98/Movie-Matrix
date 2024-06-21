package com.app.moviematrix.domain.repository

import com.app.moviematrix.data.model.trending.TrendingResponse


interface TrendingRepository {
    suspend fun getTrendingPerson(page:Int): TrendingResponse
    suspend fun getTrendingMovie(apikey: String): TrendingResponse
    suspend fun getTrendingTvShow(apikey: String): TrendingResponse
}
