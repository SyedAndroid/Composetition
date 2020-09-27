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
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun HomeView() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        val context = ContextAmbient.current

        Surface(color = Color.Yellow) {
            Column(
                    modifier = Modifier.padding(16.dp)
                        .fillMaxHeight()
            ) {
                Column(modifier = Modifier.weight(1f)) {

                    Text(
                        "Hello World!",
                        style = typography.h1
                    )
                    Spacer(Modifier.preferredHeight(10.dp))
                    Text(
                        "Something is actually working.",
                        style = typography.body1
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        Toast.makeText(context, "You just pushed a button", Toast.LENGTH_SHORT)
                            .show()
                    }) {
                        Text("A button")
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

