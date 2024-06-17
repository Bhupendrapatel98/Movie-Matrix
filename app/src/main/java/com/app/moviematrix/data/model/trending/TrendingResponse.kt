package com.app.moviematrix.data.model.trending

data class TrendingResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int,
)
