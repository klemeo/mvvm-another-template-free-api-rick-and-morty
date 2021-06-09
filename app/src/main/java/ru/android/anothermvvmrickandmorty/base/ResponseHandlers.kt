package ru.android.anothermvvmrickandmorty.base

import retrofit2.Response

inline fun <T> Response<T>.handleResponse(
    onSuccess: (T) -> Unit = {}
): T {
    if (this.isSuccessful) {
        val body = this.body()
        if (body != null) {
            onSuccess.invoke(body)
        }
        return body ?: throw Exception()
    } else {
        throw Exception(
            this.errorBody()?.string()
        )
    }
}

inline fun <T> Response<T>.handleNullableResponse(
    onSuccess: (T?) -> Unit = {}
): T? {
    if (this.isSuccessful) {
        val body = this.body()
        onSuccess.invoke(body)
        return body
    } else {
        throw Exception(
            this.errorBody()?.string()
        )
    }
}

/**
 * Use when no answer required from api
 */
inline fun Response<*>.handleEmptyResponse(
    onSuccess: () -> Unit = {}
) {
    if (!this.isSuccessful) {
        throw Exception(
            this.errorBody()?.string()
        )
    } else {
        onSuccess()
    }
}