package net.BnpTestApp.designSystem.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class BnpTestAppSpacing(
    val smallSpacing: Dp,
    val screenHorizontalMargin: Dp,
    val listVerticalSpacing: Dp,
    val listItemHeight: Dp
)

val bnpTestAppSpacing = BnpTestAppSpacing(
    smallSpacing = 4.dp,
    screenHorizontalMargin = 24.dp,
    listVerticalSpacing = 16.dp,
    listItemHeight = 80.dp
)