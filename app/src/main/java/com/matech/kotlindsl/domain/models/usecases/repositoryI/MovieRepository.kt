package com.matech.kotlindsl.domain.models.usecases.repositoryI

import com.matech.kotlindsl.data.remote.dto.MoviesListDTO
import com.matech.kotlindsl.domain.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMoviesList(): Flow<Resource<MoviesListDTO>>

}