package com.foodie.composetition.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "star_table")
class StarCounter(
    @PrimaryKey val id: Long,
    val stars: Int,
)