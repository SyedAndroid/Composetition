package com.foodie.composetition.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.foodie.composetition.repository.Restaurant
import com.foodie.composetition.utils.Resource
import com.foodie.composetition.viewmodels.RestaurantViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun RestaurantListView(
    viewModel: RestaurantViewModel,
    selectRestaurant: (Long) -> Unit
) {
    val restaurantsResource: Resource<List<Restaurant>> by viewModel.restaurantList.observeAsState(
        Resource(Resource.Status.LOADING, null, null)
    )
    Surface(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        color = Color.White,
    ) {
        when (restaurantsResource.status) {
            Resource.Status.SUCCESS -> {
                if (!restaurantsResource.data.isNullOrEmpty()) {
                    loadList(ArrayList(restaurantsResource.data!!), selectRestaurant)
                }
            }
            Resource.Status.LOADING -> {
                // TODO handle loading state
            }
            Resource.Status.ERROR -> {
                //TODO handle error state
            }
        }
    }
}


@Composable
fun loadList(restaurants: List<Restaurant>, selectRestaurant: (Long) -> Unit) {

    LazyColumnFor(restaurants, modifier = Modifier.padding(16.dp)) {
        restaurants.forEach { restaurant ->
            restaurantItem(restaurant, selectRestaurant)
        }
    }
}

@Composable
fun restaurantItem(restaurant: Restaurant, selectRestaurant: (Long) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
            .clickable(onClick = { selectRestaurant(restaurant.id) })
    ) {
        CoilImage(
            request = ImageRequest.Builder(ContextAmbient.current)
                .data(restaurant.smallImageLink)
                .transformations(CircleCropTransformation())
                .build(),
            modifier = Modifier.preferredSize(64.dp)
                .clip(MaterialTheme.shapes.medium)
                .size(64.dp, 64.dp)
        )

        Spacer(Modifier.preferredWidth(8.dp))

        Text(
            restaurant.name,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }

}