package com.foodie.composetition.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.viewModel
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.foodie.composetition.R
import com.foodie.composetition.utils.Resource
import com.foodie.composetition.viewmodels.RestaurantListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_restuarent_list.*

@AndroidEntryPoint
class RestaurantListFragment : Fragment() {

    private val viewModel: RestaurantListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    // In Compose world
                    Text("Hello Compose!")
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.restaurantResponse.observe(viewLifecycleOwner, Observer {

            when (it.status) {
                Resource.Status.SUCCESS -> {
                }


            }
        })
    }

}