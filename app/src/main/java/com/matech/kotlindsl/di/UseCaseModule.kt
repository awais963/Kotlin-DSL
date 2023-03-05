package com.matech.kotlindsl.di

import com.matech.kotlindsl.data.remote.repository.MoviesRepositoryImpl
import com.matech.kotlindsl.data.repository.service.MoviesService
import com.matech.kotlindsl.domain.models.usecases.repositoryI.MovieRepository
import com.matech.kotlindsl.network.RemoteDataClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    fun provideUsersRepository(api: MoviesService): MovieRepository {
        return MoviesRepositoryImpl(api)
    }
}