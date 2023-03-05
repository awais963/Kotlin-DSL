package com.matech.kotlindsl.data.repository.service

import com.matech.kotlindsl.data.remote.dto.MoviesListDTO
import retrofit2.http.GET

interface MoviesService {
    @GET("/moviesList")
    suspend fun getMoviesList(): MoviesListDTO
}