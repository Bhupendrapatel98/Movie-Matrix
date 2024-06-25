package com.app.moviematrix.data.remote.repository

import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.data.remote.api.ApiService
import com.app.moviematrix.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    MovieRepository {
    override suspend fun getUpComingMovies(apiKey: String): TrendingResponse {
        return apiService.getUpcomingMovie(apiKey)
    }

    override suspend fun getPopularMovies(page:Int): TrendingResponse {
        return apiService.getPopularMovie(page)
    }
}