package com.foodie.composetition.ui.composables

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.ui.tooling.preview.Preview


@Composable
fun MichelinStarRow(stars: Int, totalCount: Int, modifier: Modifier? = null) {
    var stars = maxOf(minOf(stars, 3), 0)

    Row(
        modifier = (modifier ?: Modifier).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MichelinStars(stars)

        Text(
            totalCount.toString(),
            fontWeight = FontWeight(400),
            fontSize = TextUnit.Companion.Sp(24),
            fontFamily = FontFamily.Default
        )
    }
}

@Preview
@Composable
fun MichelinStarRowPreview() {
    Surface(color = Color.White) {
        MichelinStarRow(2, 7)
    }
}

