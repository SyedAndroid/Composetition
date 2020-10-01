package com.foodie.composetition.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Restaurant::class, StarCounter::class], version = 1, exportSchema = false)
public abstract class RestaurantRoomDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: RestaurantRoomDatabase? = null

        fun getDatabase(context: Context): RestaurantRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantRoomDatabase::class.java,
                    "restaurant_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}