package com.app.moviematrix.data.remote.api

import com.app.moviematrix.data.model.trendingperson.TrendingPerson
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("trending/person/day")
    suspend fun getTrendingPerson(@Query("api_key") key: String) : TrendingPerson
}