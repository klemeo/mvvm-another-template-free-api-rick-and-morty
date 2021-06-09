package ru.android.anothermvvmrickandmorty.base

import okhttp3.ResponseBody
import retrofit2.Call

interface RetrofitDataSource  {
    fun <T> executeWithResponse(call: () -> Call<T>): T = call
        .invoke()
        .execute()
        .handleResponse()

    fun <T> executeWithNullableResponse(call: () -> Call<T>): T? = call
        .invoke()
        .execute()
        .handleNullableResponse()

    fun executeWithEmptyResponse(call: () -> Call<ResponseBody>) = call
        .invoke()
        .execute()
        .handleEmptyResponse()
}