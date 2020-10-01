package com.foodie.composetition.ui.composables

import android.graphics.Color.parseColor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.foodie.composetition.R

@Composable
fun CircularImage(){
    Surface(elevation = 10.dp, modifier = Modifier.clip(shape = CircleShape)) {
        Image(asset = imageResource(id = R.drawable.arzak_entrance),
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(288.dp).height(288.dp)
                    .clip(shape = CircleShape)
                    .border(width = 4.dp,
                            color= Color(parseColor("#A42330"))))

    }
}


@Preview
@Composable
fun CircularImagePreview(){
    Surface(modifier = Modifier.width(300.dp).height(300.dp) ) {
        CircularImage()
    }

}