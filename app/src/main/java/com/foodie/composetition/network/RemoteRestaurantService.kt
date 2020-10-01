package com.foodie.composetition.network

import com.foodie.composetition.data.RestaurantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RemoteRestaurantService {

    @GET("eng")
    suspend fun listRestaurants(@Query("center") center: String = "18.09:59.35"): Response<RestaurantResponse>
}