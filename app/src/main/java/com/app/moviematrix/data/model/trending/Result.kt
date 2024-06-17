package com.app.moviematrix.data.model.trending

data class Result(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownFor>,
    val known_for_department: String,
    val media_type: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String,
    val backdrop_path: String?,
    val original_title: String?,
    val overview: String?,
    val poster_path: String?,
    val vote_average: Float?,
)
