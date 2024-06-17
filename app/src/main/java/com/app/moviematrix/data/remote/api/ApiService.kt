package com.app.moviematrix.data.remote.api

import com.app.moviematrix.data.model.trending.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("trending/person/day")
    suspend fun getTrendingPerson(
        @Query("api_key") key: String,
    ): TrendingResponse

    @GET("trending/movie/day")
    suspend fun getTrendingMovie(
        @Query("api_key") key: String,
    ): TrendingResponse

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(
        @Query("api_key") key: String,
    ): TrendingResponse
}
