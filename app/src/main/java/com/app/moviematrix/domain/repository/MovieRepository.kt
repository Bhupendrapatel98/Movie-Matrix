package com.app.moviematrix.domain.repository

import com.app.moviematrix.data.model.trending.TrendingResponse

interface MovieRepository {
    suspend fun getUpComingMovies(apiKey:String):TrendingResponse
    suspend fun getPopularMovies(page:Int):TrendingResponse
}