package com.foodie.composetition.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities_table")
class Cities(
    @PrimaryKey val cities: String,
    val lon: Double,
    val lan: Double
)
