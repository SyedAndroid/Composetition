package com.foodie.composetition.network

import javax.inject.Inject

class RemoteRestaurants @Inject constructor(private val apiService: RemoteRestaurantService) :
    DataSource() {
    suspend fun getRestaurants() = getResult(apiService.listRestaurants())
}