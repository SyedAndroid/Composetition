package com.foodie.composetition.ui.theme

import android.graphics.Color.parseColor
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val RedLight = Color(parseColor("#DC3545"))
val RedDark = Color(parseColor("#A42330"))
val BlackLight = Color(parseColor("#2D2926"))

val LightThemeColors = lightColors(
    primary = RedLight,
    primaryVariant = RedDark,
    onPrimary = Color.White,
    secondary = Color.White,
    secondaryVariant = RedLight,
    onSecondary = RedDark
)

val DarkThemeColors = darkColors(
    primary = RedDark,
    primaryVariant = RedLight,
    onPrimary = Color.Black,
    secondary = Color.Black,
    onSecondary = RedLight
)