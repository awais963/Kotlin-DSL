package com.matech.kotlindsl.domain.models.usecases

import com.matech.kotlindsl.data.remote.dto.MoviesListDTO
import com.matech.kotlindsl.domain.Resource
import com.matech.kotlindsl.domain.models.usecases.repositoryI.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): Flow<Resource<MoviesListDTO>> {

        return repository.getMoviesList()
    }
}