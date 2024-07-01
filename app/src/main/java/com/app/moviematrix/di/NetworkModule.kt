package com.app.moviematrix.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.app.moviematrix.data.local.MIGRATION_1_2
import com.app.moviematrix.data.local.dao.MoviesDao
import com.app.moviematrix.data.local.database.MoviesDatabase
import com.app.moviematrix.data.local.dao.RemoteKeysDao
import com.app.moviematrix.data.remote.api.ApiService
import com.app.moviematrix.data.remote.repository.MovieRepositoryImpl
import com.app.moviematrix.data.remote.repository.TrendingRepositoryImpl
import com.app.moviematrix.domain.repository.MovieRepository
import com.app.moviematrix.domain.repository.TrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDataBse(@ApplicationContext context: Context): MoviesDatabase {
        return Room.databaseBuilder(context, MoviesDatabase::class.java, "movies_database")
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviesDao(moviesDatabase: MoviesDatabase): MoviesDao {
        return moviesDatabase.getMoviesDao()
    }

    @Singleton
    @Provides
    fun provideRemoteKeyDao(moviesDatabase: MoviesDatabase): RemoteKeysDao {
        return moviesDatabase.getRemoteKeysDao()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideTrendingPersonRepository(apiService: ApiService): TrendingRepository {
        return TrendingRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(apiService: ApiService): MovieRepository {
        return MovieRepositoryImpl(apiService)
    }
}
