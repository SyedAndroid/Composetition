package com.foodie.composetition

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.foodie.composetition.navigation.RestaurantMain
import com.foodie.composetition.viewmodels.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: RestaurantViewModel by viewModels()

        supportActionBar?.hide()

        setContent {
            RestaurantMain(viewModel, onBackPressedDispatcher)
        }
    }
}
