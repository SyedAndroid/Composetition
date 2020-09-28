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
import com.foodie.composetition.ui.composables.MichelinStarTotal

@Composable
fun HomeView() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        val context = ContextAmbient.current

        Surface(color = Color.White) {
            Column(
                    modifier = Modifier.padding(16.dp).fillMaxHeight()
            ) {
                Column(modifier = Modifier.weight(1f).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(Modifier.preferredHeight(60.dp))
                    Text("YOUR STAR-METER",
                            color = Color(android.graphics.Color.parseColor("#2D2926")),
                            fontWeight = FontWeight(400),
                            fontSize = TextUnit.Companion.Sp(14),
                            fontFamily = FontFamily.Default
                    )
                    Spacer(Modifier.preferredHeight(16.dp))
                    Text(
                        "You have visited 11 Michelin star restaurants.",
                            color = Color(android.graphics.Color.parseColor("#2D2926")),
                            fontWeight = FontWeight(700),
                            fontSize = TextUnit.Companion.Sp(16),
                            fontFamily = FontFamily.Default
                    )
                    Text(
                            "Adding up to 20 Michelin stars in total.",
                            color = Color(android.graphics.Color.parseColor("#2D2926")),
                            fontWeight = FontWeight(700),
                            fontSize = TextUnit.Companion.Sp(16),
                            fontFamily = FontFamily.Default
                    )
                    MichelinStarTotal()
                }



                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(backgroundColor = Color(android.graphics.Color.parseColor("#DC3545")),
                            contentColor = Color.White,
                            modifier = Modifier.fillMaxWidth().preferredHeight(60.dp),
                            onClick = {
                        Toast.makeText(context, "You just pushed a button", Toast.LENGTH_SHORT)
                            .show()
                    }){
                        Text("Explore restaurants",
                                fontWeight = FontWeight(400),
                                fontSize = TextUnit.Companion.Sp(20),
                                fontFamily = FontFamily.Default)
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

