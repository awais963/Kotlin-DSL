package com.matech.kotlindsl.di

import com.matech.kotlindsl.data.repository.service.MoviesService
import com.matech.kotlindsl.network.RemoteDataClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideMoviesList(remoteDataSource: RemoteDataClient): MoviesService {

        return remoteDataSource.buildApi(MoviesService::class.java)
    }
}