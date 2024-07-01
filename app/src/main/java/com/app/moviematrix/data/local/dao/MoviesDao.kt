package com.app.moviematrix.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.moviematrix.data.model.trending.Result

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movie: List<Result>)


    @Query("Select * From movies order By page")
    fun getMovies(): PagingSource<Int, Result>

    @Query("Select * From movies Where type = :type order By page")
    fun getMoviesByType(type:String): PagingSource<Int, Result>

    @Query("Delete from movies")
    suspend fun clearAllMovies()

    @Query("Delete from movies Where type = :type")
    suspend fun clearMoviesByType(type:String)
}