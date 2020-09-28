package com.foodie.composetition.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.foodie.composetition.R


@Composable
fun MichelinStars(count: Int) {

    var stars = maxOf(minOf(count, 3), 0)
    Row() {
        while (stars > 0) {
            Surface(modifier = Modifier.padding(end = 16.dp)) {
                Image(asset = imageResource(R.drawable.star),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.width(33.dp))
            }
            stars--
        }
    }
}

@Preview
@Composable
fun MichelinStarsPreview() {
    MichelinStars(3)
}

