package com.foodie.composetition.ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
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


@Composable
fun RestaurantVisits(count: Int) {
    Row(modifier = Modifier.fillMaxWidth().padding(36.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text("Visits",
            fontWeight = FontWeight(700),
            fontSize = TextUnit.Companion.Sp(18),
            fontFamily = FontFamily.Default
        )
        Text(count.toString(),
            fontWeight = FontWeight(400),
            fontSize = TextUnit.Companion.Sp(18),
            fontFamily = FontFamily.Default
        )
    }
}

@Preview
@Composable
fun RestaurantVisitsPreview() {
    Surface(color = Color.White) {
        RestaurantVisits(2)
    }
}

