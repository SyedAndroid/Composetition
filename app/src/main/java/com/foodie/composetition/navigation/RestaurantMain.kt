/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.foodie.composetition.navigation

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import com.foodie.composetition.ui.HomeView
import com.foodie.composetition.ui.RestaurantDetailView
import com.foodie.composetition.ui.RestaurantListView
import com.foodie.composetition.utils.ProvideDisplayInsets
import com.foodie.composetition.viewmodels.RestaurantViewModel


@Composable
fun RestaurantMain(viewModel: RestaurantViewModel, backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSavedInstanceState(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }

    Providers(BackDispatcherAmbient provides backDispatcher) {
        ProvideDisplayInsets {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    Destination.Home -> {
                        viewModel.getRestaurantVisited()
                        HomeView(viewModel, goToRestaurantList = actions.browseRestaurants)
                    }

                    Destination.RestaurantList -> {
                        viewModel.getRestaurantList()
                        RestaurantListView(
                            viewModel = viewModel,
                            selectRestaurant = actions.selectOnRestaurant
                        )
                    }
                    is Destination.RestaurantDetail -> {
                        viewModel.getRestaurant(destination.restaurantId)
                        RestaurantDetailView(
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}


