package com.foodie.composetition.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.foodie.composetition.repository.RestaurantRepository

class RestaurantListViewModel @ViewModelInject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    val restaurantResponse = repository.getRestaurants()

}