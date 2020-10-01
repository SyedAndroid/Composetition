package com.foodie.composetition.ui

import android.widget.Toast
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
import com.foodie.composetition.repository.Restaurant
import com.foodie.composetition.ui.composables.CircularImage
import com.foodie.composetition.ui.composables.MichelinStars
import com.foodie.composetition.ui.composables.RestaurantVisits
import com.foodie.composetition.ui.theme.textColor
import com.foodie.composetition.ui.theme.titleTextColor
import com.foodie.composetition.viewmodels.RestaurantListViewModel

@Composable
fun RestaurantDetailView(viewModel: RestaurantListViewModel, visitClicked: () -> Unit) {

    val details: Restaurant? by viewModel.restaurantDetails.observeAsState()

    val context = ContextAmbient.current
    details?.let {
        Surface(color = Color.White) {
            Column(
                modifier = Modifier.fillMaxHeight().fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CircularImage()
                    Spacer(modifier = Modifier.preferredHeight(40.dp))

                    MichelinStars(count = it.michelinRating)
                    Spacer(modifier = Modifier.preferredHeight(24.dp))

                    Text(
                        text = it.name,
                        color = MaterialTheme.colors.titleTextColor,
                        style = MaterialTheme.typography.h4
                    )
                    Spacer(modifier = Modifier.preferredHeight(10.dp))

                    Text(
                        text = it.address,
                        color = MaterialTheme.colors.textColor,
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = it.city,
                        color = MaterialTheme.colors.textColor,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.preferredHeight(10.dp))

                    RestaurantVisits(count = 19)
                    Spacer(modifier = Modifier.preferredHeight(10.dp))

                    Button(backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.onSecondary,
                        modifier = Modifier.fillMaxWidth().preferredHeight(60.dp),
                        onClick = {
                            Toast.makeText(context, "You just pushed a button", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                        Text(
                            "Request update",
                            style = MaterialTheme.typography.button
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.fillMaxWidth().preferredHeight(60.dp),
                        onClick = {
                            Toast.makeText(context, "You just pushed a button", Toast.LENGTH_SHORT)
                                .show()
                        }) {
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

@Preview
@Composable
fun RestaurantDetailViewPreview() {
    //RestaurantDetailView()
}