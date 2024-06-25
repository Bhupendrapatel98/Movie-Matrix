package com.app.moviematrix.domain.repository

import com.app.moviematrix.data.model.trending.TrendingResponse


interface TrendingRepository {
    suspend fun getTrendingPerson(page:Int): TrendingResponse
    suspend fun getTrendingMovie(page:Int): TrendingResponse
    suspend fun getTrendingTvShow(page:Int): TrendingResponse
}
