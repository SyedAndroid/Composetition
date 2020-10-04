package com.foodie.composetition.viewmodels

import androidx.annotation.WorkerThread
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodie.composetition.repository.Restaurant
import com.foodie.composetition.repository.RestaurantRepository
import com.foodie.composetition.repository.StarCounter
import com.foodie.composetition.utils.Resource
import kotlinx.coroutines.launch

class RestaurantViewModel @ViewModelInject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private var _restaurantDetails: LiveData<Restaurant> = MutableLiveData()
    val restaurantDetails: LiveData<Restaurant> get() = _restaurantDetails

    private var _starCount: LiveData<List<StarCounter>> = MutableLiveData()
    val restaurantsVisited: LiveData<List<StarCounter>> get() = _starCount

    private var _restaurantList: LiveData<Resource<List<Restaurant>>> = MutableLiveData()
    val restaurantList: LiveData<Resource<List<Restaurant>>> get() = _restaurantList

    fun insertStars(restaurantId: Long, stars: Int) {
        viewModelScope.launch {
            repository.insertStars(StarCounter(restaurantId, stars = stars))
        }
    }

    @WorkerThread
    fun getRestaurant(id: Long) {
        _restaurantDetails = repository.getRestaurant(id)
    }

    @WorkerThread
    fun getRestaurantVisited() {
        _starCount = repository.getStars()
    }

    fun getRestaurantList() {
        viewModelScope.launch {
            _restaurantList = repository.getRestaurants()
        }
    }

}