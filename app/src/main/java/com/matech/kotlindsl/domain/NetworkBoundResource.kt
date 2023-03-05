package com.matech.kotlindsl.domain


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow<Resource<ResultType>>  {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}.flowOn(Dispatchers.IO)


inline fun <T> networkBoundResource(
    crossinline query: () -> Flow<T>,
) = channelFlow {

    val data = query().first()
    send(Resource.Success(data))
}.flowOn(Dispatchers.IO)

inline fun <T> networkBoundResource(
    crossinline fetch: suspend () -> T
) = channelFlow {
    send(Resource.Loading(null))
    try {
        send(Resource.Success(fetch()))
    } catch (throwable: Throwable) {
        send(Resource.Error(throwable, null))
        throwable.printStackTrace()
    }
}.flowOn(Dispatchers.IO)

