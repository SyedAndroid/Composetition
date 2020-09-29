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
import com.foodie.composetition.ui.composables.CircularImage
import com.foodie.composetition.ui.composables.MichelinStarRow
import com.foodie.composetition.ui.composables.MichelinStars
import com.foodie.composetition.ui.composables.RestaurantVisits

@Composable
fun RestaurantDetailView() {
    MaterialTheme {
        val context = ContextAmbient.current

        Surface(color = Color.White) {
            Column(
                modifier = Modifier.fillMaxHeight().fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CircularImage()
                    Spacer(modifier = Modifier.preferredHeight(40.dp))
                    MichelinStars(count = 2)
                    Spacer(modifier = Modifier.preferredHeight(24.dp))
                    Text(
                        text = "Arzak",
                        color = Color(android.graphics.Color.parseColor("#2D2926")),
                        fontWeight = FontWeight(600),
                        fontSize = TextUnit.Companion.Sp(20),
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.preferredHeight(10.dp))
                    Text(
                        text = "Humlegårdsgatan 17",
                        color = Color(android.graphics.Color.parseColor("#2D2926")),
                        fontWeight = FontWeight(400),
                        fontSize = TextUnit.Companion.Sp(16),
                        fontFamily = FontFamily.Default
                    )
                    Text(
                        text = "Stockholm, Sweden",
                        color = Color(android.graphics.Color.parseColor("#2D2926")),
                        fontWeight = FontWeight(400),
                        fontSize = TextUnit.Companion.Sp(16),
                        fontFamily = FontFamily.Default
                    )
                    Spacer(modifier = Modifier.preferredHeight(10.dp))
                    RestaurantVisits(count = 19)
                    Spacer(modifier = Modifier.preferredHeight(10.dp))
                    Button(backgroundColor = Color(android.graphics.Color.parseColor("#FFFFFF")),
                        contentColor = Color(android.graphics.Color.parseColor("#A42330")),
                        modifier = Modifier.fillMaxWidth().preferredHeight(60.dp),
                        onClick = {
                            Toast.makeText(context, "You just pushed a button", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                        Text(
                            "Request update",
                            fontWeight = FontWeight(500),
                            fontSize = TextUnit.Sp(20),
                            fontFamily = FontFamily.Default
                        )

                    }
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
                        }) {
                        Text(
                            "Explore restaurants",
                            fontWeight = FontWeight(400),
                            fontSize = TextUnit.Companion.Sp(20),
                            fontFamily = FontFamily.Default
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RestaurantDetailViewPreview() {
    RestaurantDetailView()
}