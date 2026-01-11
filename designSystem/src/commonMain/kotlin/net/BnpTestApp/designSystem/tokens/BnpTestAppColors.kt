package net.BnpTestApp.designSystem.tokens

import androidx.compose.ui.graphics.Color

data class BnpTestAppColors (
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val background: Color,
    val surface: Color
)


val bnpTestAppColors = BnpTestAppColors(
    primary = Color.Red,
    secondary = Color.Blue,
    tertiary = Color.Gray,
    background = Color.White,
    surface = Color.LightGray
)