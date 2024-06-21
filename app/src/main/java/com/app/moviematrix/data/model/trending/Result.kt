package com.app.moviematrix.data.model.trending

data class Result(
    val adult: Boolean?=false,
    val gender: Int?=null,
    val id: Int?=null,
    val known_for: List<KnownFor>?=null,
    val known_for_department: String?=null,
    val media_type: String?=null,
    val name: String?=null,
    val original_name: String?=null,
    val popularity: Double?=null,
    val profile_path: String?=null,
    val backdrop_path: String?=null,
    val original_title: String?=null,
    val overview: String?=null,
    val poster_path: String?=null,
    val vote_average: Float?=null,
)
