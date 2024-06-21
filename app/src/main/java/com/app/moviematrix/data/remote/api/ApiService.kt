package com.app.moviematrix.data.remote.api

import com.app.moviematrix.BuildConfig
import com.app.moviematrix.data.model.trending.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("trending/person/day")
    suspend fun getTrendingPerson(@Query("page") page:Int,
        @Query("api_key") key: String=BuildConfig.API_KEY,
    ): TrendingResponse

    @GET("trending/movie/day")
    suspend fun getTrendingMovie(
        @Query("api_key") key: String,
    ): TrendingResponse

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(
        @Query("api_key") key: String,
    ): TrendingResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(
        @Query("api_key") key: String,
    ): TrendingResponse

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") key: String,
    ): TrendingResponse
}
