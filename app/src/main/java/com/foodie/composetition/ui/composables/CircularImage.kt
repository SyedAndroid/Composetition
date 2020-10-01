package com.foodie.composetition.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CircularImage(url: String) {
    Surface(
        color = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.width(296.dp)
            .height(296.dp)
            .clip(shape = CircleShape)
    ) {
        CoilImage(
            request = ImageRequest.Builder(ContextAmbient.current)
                .data(url)
                .transformations(CircleCropTransformation())
                .build(),
            modifier = Modifier.preferredSize(288.dp)
                .clip(MaterialTheme.shapes.medium)
                .height(288.dp).fillMaxWidth(),
            alignment = Alignment.TopCenter
        )

//        Image(
//            asset = imageResource(id = R.drawable.arzak_entrance),
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.width(288.dp)
//                .height(288.dp)
//                .clip(shape = CircleShape), alignment = Alignment.Center
//        )
    }
}


@Preview
@Composable
fun CircularImagePreview() {
    //CircularImage()
}