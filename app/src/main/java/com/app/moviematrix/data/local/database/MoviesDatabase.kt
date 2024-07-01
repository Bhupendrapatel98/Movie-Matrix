package com.app.moviematrix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.moviematrix.data.local.RemoteKeys
import com.app.moviematrix.data.local.dao.MoviesDao
import com.app.moviematrix.data.local.dao.RemoteKeysDao
import com.app.moviematrix.data.model.trending.Result

@Database(
    entities = [Result::class, RemoteKeys::class],
    version = 2
)
@TypeConverters(Converters::class)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao
}