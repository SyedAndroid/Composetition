package com.foodie.composetition.ui.composables

import android.R
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.ui.tooling.preview.Preview


@Composable
fun MichelinStarTotal() {
    Text(
            "20",
            fontWeight = FontWeight(300),
            fontSize = TextUnit.Companion.Sp(120),
            color = Color(android.graphics.Color.parseColor("#A42330")),
            fontFamily = FontFamily.Default)
}

@Preview
@Composable
fun MichelinStarTotalPreview() {
    MichelinStarTotal()
}

