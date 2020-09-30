package com.foodie.composetition.ui

import android.widget.Toast
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.foodie.composetition.ui.composables.MichelinStarRow
import com.foodie.composetition.ui.composables.MichelinStarTotal
import com.foodie.composetition.ui.theme.Theme
import com.foodie.composetition.ui.theme.textColor

@Composable
fun HomeView() {
    val context = ContextAmbient.current
    Theme() {
        Surface(color = Color.White) {
            Column(
                    modifier = Modifier.padding(16.dp).fillMaxHeight()
            ) {
                Column(modifier = Modifier.weight(1f).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(Modifier.preferredHeight(16.dp))
                    Text(
                        "YOUR STAR-METER",
                        color = Color(android.graphics.Color.parseColor("#2D2926")),
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(Modifier.preferredHeight(16.dp))
                    Text(
                        "You have visited 11 Michelin star restaurants.",
                            color = Color(android.graphics.Color.parseColor("#2D2926")),
                            style = MaterialTheme.typography.body2
                    )
                    Text(
                            "Adding up to 20 Michelin stars in total.",
                            color = MaterialTheme.colors.textColor,
                            style = MaterialTheme.typography.body2
                    )
                    Spacer(Modifier.preferredHeight(48.dp))
                    MichelinStarTotal()
                }



                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MichelinStarRow(stars = 1, totalCount = 5, Modifier.padding(16.dp))
                    MichelinStarRow(stars = 2, totalCount = 8, Modifier.padding(horizontal = 16.dp))
                    MichelinStarRow(stars = 3, totalCount = 7, Modifier.padding(16.dp))

                    Button(backgroundColor = MaterialTheme.colors.primary,
                            contentColor =  MaterialTheme.colors.onPrimary,
                            modifier = Modifier.fillMaxWidth().preferredHeight(60.dp),
                            onClick = {
                        Toast.makeText(context, "You just pushed a button", Toast.LENGTH_SHORT)
                            .show()
                    }){
                        Text("Explore restaurants",
                            style = MaterialTheme.typography.button)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeViewPreview() {
    HomeView()
}
