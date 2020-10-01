package com.foodie.composetition.ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.foodie.composetition.R
import com.foodie.composetition.ui.theme.Theme
import com.foodie.composetition.ui.theme.textColor


@Composable
fun RestaurantVisits(count: Int) {
    Theme() {
        Row(modifier = Modifier.fillMaxWidth().padding(36.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Visits",
                color = MaterialTheme.colors.textColor,
                style = MaterialTheme.typography.h5
            )
            Text(count.toString(),
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

