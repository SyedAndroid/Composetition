package com.foodie.composetition.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
class Restaurant(
    @PrimaryKey val id: Long,
    val name: String,
    val desc: String,
    val lat: Double,
    val lon: Double,
    val address: String,
    val city: String,
    val michelinRating: Int,
    val imageLink: String
)



