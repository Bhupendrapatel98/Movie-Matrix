package com.app.moviematrix.data.model.trending

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Result(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val adult: Boolean?=false,
    val gender: Int?,
    val known_for: List<KnownFor>,
    val known_for_department: String?,
    val media_type: String?,
    val name: String?,
    val original_name: String?,
    val popularity: Double?,
    val profile_path: String?,
    val backdrop_path: String?,
    val original_title: String?,
    val overview: String?,
    val poster_path: String?,
    val vote_average: Float?,
    val release_date: String?,
    val first_air_date: String?,
    var page: Int,
    var type:String
)
