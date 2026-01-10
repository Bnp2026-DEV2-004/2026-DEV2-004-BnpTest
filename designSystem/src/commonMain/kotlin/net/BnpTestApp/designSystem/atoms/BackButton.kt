package net.BnpTestApp.designSystem.atoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import net.BnpTestApp.designSystem.tokens.bnpTestAppColors
import net.BnpTestApp.designSystem.tokens.bnpTestAppSpacing
import net.BnpTestApp.designSystem.tokens.rememberChevronRight

@Composable
fun UpButton(
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(bnpTestAppSpacing.smallSpacing).clickable { onClick() },
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Icon(
            rememberChevronRight(),
            tint = bnpTestAppColors.tertiary,
            contentDescription = label,
            modifier = Modifier
                .padding(start = bnpTestAppSpacing.smallSpacing, end = bnpTestAppSpacing.smallSpacing)
                .rotate(180f),
        )
        Text(label, color = bnpTestAppColors.tertiary)
    }
}