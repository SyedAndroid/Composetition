package com.foodie.composetition.ui.composables

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


@Composable
fun MichelinStarTotal() {
    Stack(alignment = Alignment.Center) {
        Text(
                "20",
                fontWeight = FontWeight(300),
                fontSize = TextUnit.Companion.Sp(120),
                color = Color(android.graphics.Color.parseColor("#A42330")),
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(bottom = 30.dp))

        Image(imageResource(com.foodie.composetition.R.drawable.wreath),
                contentScale = ContentScale.Fit,
                modifier = Modifier.width(264.dp)
        )
    }
}

@Preview
@Composable
fun MichelinStarTotalPreview() {
    Surface(color = Color.White) {
        
    }
    MichelinStarTotal()
}

