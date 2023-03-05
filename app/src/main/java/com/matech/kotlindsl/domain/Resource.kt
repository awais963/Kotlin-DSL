package com.matech.kotlindsl.domain

import com.matech.kotlindsl.data.remote.dto.MoviesListDTO
import kotlinx.coroutines.flow.Flow

/*
sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class NetworkFailure(
        val isNetworkError: Boolean
    ) : Resource<Nothing>()

    data class Failure(
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()

    object Loading : Resource<Nothing>()
    object Idle : Resource<Nothing>()
}*/
sealed class Resource<out T>(val result: T? = null, val error: Throwable? = null) {
    class Success<out T>(result: T) : Resource<T>(result)
    class Loading<T>(result: T? = null) : Resource<T>(result)
    class Error<T>(throwable: Throwable, result: T? = null) : Resource<T>(result, throwable)
}
