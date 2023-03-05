package com.matech.kotlindsl.data.remote.repository

import com.matech.kotlindsl.data.remote.dto.MoviesListDTO
import com.matech.kotlindsl.data.repository.service.MoviesService
import com.matech.kotlindsl.domain.Resource
import com.matech.kotlindsl.domain.models.usecases.repositoryI.MovieRepository
import com.matech.kotlindsl.domain.networkBoundResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: MoviesService
) : MovieRepository {
    override suspend fun getMoviesList() =
        networkBoundResource(
            fetch = { api.getMoviesList() }
        )

}