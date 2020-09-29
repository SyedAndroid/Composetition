package com.foodie.composetition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.viewModels
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.foodie.composetition.fragments.RestaurantListFragment
import com.foodie.composetition.viewmodels.RestaurantListViewModel
import com.foodie.composetition.viewmodels.StartViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_activity.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, RestaurantListFragment())
            .commit()
    }
}

@Preview
@Composable
fun TestComposable() {
    Surface(color = Color.White) {
        Text("Test")
    }
}


