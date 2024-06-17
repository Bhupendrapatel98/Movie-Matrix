package com.app.moviematrix.di

import com.app.moviematrix.data.remote.api.ApiService
import com.app.moviematrix.data.remote.repository.TrendingRepositoryImpl
import com.app.moviematrix.domain.repository.TrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideTrendingPersonRepository(apiService: ApiService): TrendingRepository {
        return TrendingRepositoryImpl(apiService)
    }
}
