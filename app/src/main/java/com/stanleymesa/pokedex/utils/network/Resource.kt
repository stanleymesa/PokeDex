package com.stanleymesa.pokedex.utils.network

sealed class Resource<out T> constructor(
    val status: NetworkState,
    val message: String? = null,
    val data: T? = null
) {

    class Success<T>(data: T, message: String? = null) : Resource<T>(
        data = data,
        status = NetworkState.SUCCESS,
        message = message
    )

    class Error<T>(message: String?) : Resource<T>(
        status = NetworkState.ERROR,
        message = if (message?.contains("No address associated with hostname") == true) "Terjadi Kesalahan" else message
    )

    class Unauthorized<T>(message: String?) : Resource<T>(
        status = NetworkState.UNAUTHORIZED, message = message
    )

    class Empty<T> : Resource<T>(status = NetworkState.EMPTY)

}

sealed class ResourcePaging<out T> constructor(
    val status: NetworkState,
    val message: String? = null,
    val data: T? = null,
    val count: Int? = null,
    val totalItems: Int? = null,
    val pageSize: Int? = null,
    val next: String? = null,
    val previous: String? = null,
) {

    class Success<T>(
        data: T,
        count: Int? = null,
        totalItems: Int? = null,
        pageSize: Int? = null,
        next: String? = null,
        previous: String? = null,
        message: String? = null
    ) : ResourcePaging<T>(
        data = data,
        count = count,
        totalItems = totalItems,
        pageSize = pageSize,
        next = next,
        previous = previous,
        message = message,
        status = NetworkState.SUCCESS,
    )

    class Error<T>(message: String?) : ResourcePaging<T>(
        status = NetworkState.ERROR,
        message = if (message?.contains("No address associated with hostname") == true) "Terjadi Kesalahan" else message
    )

    class Unauthorized<T>(message: String?) : ResourcePaging<T>(
        status = NetworkState.UNAUTHORIZED, message = message
    )

    class Empty<T> : ResourcePaging<T>(status = NetworkState.EMPTY)
}

enum class NetworkState {
    LOADING,
    SUCCESS,
    EMPTY,
    FAILED,
    UNAUTHORIZED,
    ERROR,
    IDLE
}