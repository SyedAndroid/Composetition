package com.foodie.composetition.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.foodie.composetition.repository.StarCounter
import com.foodie.composetition.ui.composables.MichelinStarRow
import com.foodie.composetition.ui.composables.MichelinStarTotal
import com.foodie.composetition.ui.theme.Theme
import com.foodie.composetition.ui.theme.textColor
import com.foodie.composetition.viewmodels.RestaurantListViewModel

@Composable
fun HomeView(
    viewModel: RestaurantListViewModel,
    goToRestaurantList: () -> Unit
) {
    val context = ContextAmbient.current
    val restaurantVisited: List<StarCounter>? by viewModel.restaurantsVisited.observeAsState()
    restaurantVisited?.let {
        var totalStars = 0
        var oneStarRestaurants = 0
        var twoStarRestaurants = 0
        var threeStarRestaurants = 0
        it.forEach { restaurant ->
            totalStars += restaurant.stars
            when (restaurant.stars) {
                1 -> oneStarRestaurants++
                2 -> twoStarRestaurants++
                3 -> threeStarRestaurants++
            }
        }


        Theme() {
            Surface(color = Color.White) {
                Column(
                    modifier = Modifier.padding(16.dp).fillMaxHeight()
                ) {
                    Column(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.preferredHeight(16.dp))
                        Text(
                            "YOUR STAR-METER",
                            color = Color(android.graphics.Color.parseColor("#2D2926")),
                            style = MaterialTheme.typography.caption
                        )
                        Spacer(Modifier.preferredHeight(16.dp))
                        Text(
                            "You have visited 11 Michelin star restaurants.",
                            color = Color(android.graphics.Color.parseColor("#2D2926")),
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            "Adding up to 20 Michelin stars in total.",
                            color = MaterialTheme.colors.textColor,
                            style = MaterialTheme.typography.body2
                        )
                        Spacer(Modifier.preferredHeight(48.dp))
                        MichelinStarTotal(totalStars)
                    }



                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MichelinStarRow(
                            stars = 1,
                            totalCount = oneStarRestaurants,
                            Modifier.padding(16.dp)
                        )
                        MichelinStarRow(
                            stars = 2,
                            totalCount = twoStarRestaurants,
                            Modifier.padding(horizontal = 16.dp)
                        )
                        MichelinStarRow(
                            stars = 3,
                            totalCount = threeStarRestaurants,
                            Modifier.padding(16.dp)
                        )

                        Button(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.fillMaxWidth().preferredHeight(60.dp),
                            onClick =
                            goToRestaurantList
                        ) {
                            Text(
                                "Explore restaurants",
                                style = MaterialTheme.typography.button
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeViewPreview() {
    // HomeView()
}
