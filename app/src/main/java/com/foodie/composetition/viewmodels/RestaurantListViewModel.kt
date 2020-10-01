package com.foodie.composetition.viewmodels

import androidx.annotation.WorkerThread
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.foodie.composetition.repository.Restaurant
import com.foodie.composetition.repository.RestaurantRepository

class RestaurantListViewModel @ViewModelInject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {


    private var _restaurantDetails: LiveData<Restaurant> = MutableLiveData()
    val restaurantDetails: LiveData<Restaurant> get() = _restaurantDetails


    var restaurantResponse = repository.getRestaurants()

    @WorkerThread
    fun getRestaurant(id: Long) {
        _restaurantDetails = repository.getRestaurant(id)
    }
}