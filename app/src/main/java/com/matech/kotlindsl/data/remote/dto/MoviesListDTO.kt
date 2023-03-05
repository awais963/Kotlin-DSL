package com.matech.kotlindsl.data.remote.dto

data class MoviesListDTO(
    val response_code: Int,
    val results: List<Result>
)