package com.foodie.composetition.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = Typo,
        content = content
    )
}

@Composable
val Colors.textColor: Color
    get() = if (isLight) BlackLight else Color.White

@Composable
val Colors.titleTextColor: Color
    get() = if (isLight) Color.Black else Color.White
