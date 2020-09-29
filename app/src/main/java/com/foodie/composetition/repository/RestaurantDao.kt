package com.foodie.composetition.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RestaurantDao {

    @Query("SELECT * from restaurant_table")
    fun getRestaurants(): LiveData<List<Restaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(restaurant: List<Restaurant>)

    @Query("DELETE FROM restaurant_table")
    suspend fun deleteAll()
}