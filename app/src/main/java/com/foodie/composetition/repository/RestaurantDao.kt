package com.foodie.composetition.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RestaurantDao {

    @Query("SELECT * from restaurant_table ")
    fun getRestaurants(): LiveData<List<Restaurant>>

    @Query("SELECT * from restaurant_table")
    fun getRestaurantsAsList(): List<Restaurant>

    @Query("SELECT * FROM restaurant_table WHERE id = :id_")
    fun getRestaurant(id_: Long): LiveData<Restaurant>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(restaurant: List<Restaurant>)

    @Query("DELETE FROM restaurant_table")
    suspend fun deleteAll()
}