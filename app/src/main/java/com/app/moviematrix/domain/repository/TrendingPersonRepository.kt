package com.app.moviematrix.domain.repository

import com.app.moviematrix.data.model.trendingperson.TrendingPerson

interface TrendingPersonRepository {
    suspend fun getTrendingPerson(apikey: String): TrendingPerson
}