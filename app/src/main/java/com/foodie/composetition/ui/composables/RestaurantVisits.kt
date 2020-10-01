package com.foodie.composetition.ui.composables


import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.foodie.composetition.ui.theme.Theme
import com.foodie.composetition.ui.theme.textColor


@Composable
fun RestaurantVisits(count: Int) {
    Theme() {
        Row(
            modifier = Modifier.fillMaxWidth().padding(36.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Visits",
                color = MaterialTheme.colors.textColor,
                style = MaterialTheme.typography.h5
            )
            Text(
                count.toString(),
                color = MaterialTheme.colors.textColor,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview
@Composable
fun RestaurantVisitsPreview() {
    Surface(color = Color.White) {
        RestaurantVisits(2)
    }
}

