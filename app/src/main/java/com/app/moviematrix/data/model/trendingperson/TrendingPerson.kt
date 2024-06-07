package com.app.moviematrix.data.model.trendingperson

data class TrendingPerson(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)