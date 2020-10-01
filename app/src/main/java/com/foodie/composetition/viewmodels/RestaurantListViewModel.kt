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
import kotlinx.coroutines.launch

class RestaurantListViewModel @ViewModelInject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {


    private var _restaurantDetails: LiveData<Restaurant> = MutableLiveData()
    val restaurantDetails: LiveData<Restaurant> get() = _restaurantDetails

    private var _starCount: LiveData<List<StarCounter>> = MutableLiveData()
    val restaurantsVisited: LiveData<List<StarCounter>> get() = _starCount

    val restaurantsStars = repository.getStars()

    fun insertStars(restaurantId: Long, stars: Int) {
        viewModelScope.launch {
            repository.insertStars(StarCounter(restaurantId, stars = stars))
        }
    }

    var restaurantResponse = repository.getRestaurants()

    @WorkerThread
    fun getRestaurant(id: Long) {
        _restaurantDetails = repository.getRestaurant(id)
    }

    @WorkerThread
    fun getRestaurantVisited() {
        _starCount = repository.getStars()
    }

}