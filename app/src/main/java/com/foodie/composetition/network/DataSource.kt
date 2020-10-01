package com.foodie.composetition.network

import com.foodie.composetition.utils.Resource
import retrofit2.Response

abstract class DataSource {

    protected suspend fun <T> getResult(call: Response<T>): Resource<T> {
        try {
            if (call.isSuccessful) {
                val body = call.body()
                if (body != null) return Resource.success(body)
            }
            return error(" ${call.code()} ${call.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }
}