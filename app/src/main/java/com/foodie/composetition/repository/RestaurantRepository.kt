package com.foodie.composetition.repository


import com.foodie.composetition.data.RestaurantResponse
import com.foodie.composetition.network.RemoteRestaurants
import com.foodie.composetition.utils.performGetOperation
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantDao: RestaurantDao,
    private val remoteRestaurants: RemoteRestaurants
) {

    fun getRestaurants() = performGetOperation(
        databaseQuery = { restaurantDao.getRestaurants() },
        networkCall = { remoteRestaurants.getRestaurants() },
        saveCallResult = { restaurantDao.insertAll(toRestaurant(it)) }
    )

    fun getRestaurant(id: Long) = restaurantDao.getRestaurant(id)

    fun getStars() = restaurantDao.getRestaurantVisited()

    suspend fun insertStars(starCounter: StarCounter) =
        restaurantDao.insertRestaurantVisited(starCounter)

    private fun toRestaurant(restaurantResponse: RestaurantResponse): List<Restaurant> {
        val restaurants = ArrayList<Restaurant>()
        restaurantResponse.poiList.forEach {
            it.datasheets.forEach { response ->
                restaurants.add(
                    Restaurant(
                        id = response.dtsId,
                        name = response.name,
                        desc = response.description,
                        lat = response.latitude,
                        lon = response.longitude,
                        address = response.address,
                        city = response.city,
                        michelinRating = response.michelinStars,
                        smallImageLink = response.medias[0].url_s,
                        largeImageLink = response.medias[0].url_l
                    )
                )
            }
        }

        return restaurants
    }
}
