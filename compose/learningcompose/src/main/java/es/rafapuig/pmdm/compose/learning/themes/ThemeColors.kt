package es.rafapuig.pmdm.compose.learning.themes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.compose.learning.ui.theme.PMDMComposeTheme
import es.rafapuig.pmdm.compose.learning.ui.theme.other.AppTheme
import es.rafapuig.pmdm.compose.learning.ui.theme.other.onPrimaryDark
import es.rafapuig.pmdm.compose.learning.ui.theme.pastel.PastelTheme

@Composable
fun ColorBox(
    color: Color,
    onColor: Color,
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(color)
    ) {
        Text(text, color = onColor, textAlign = TextAlign.Center)
    }
}

@OptIn(ExperimentalGridApi::class)
@Composable
fun ThemeColors(modifier: Modifier = Modifier) {
    Grid(config = {
        //this.row(100.dp)
        this.row(0.fr)
        this.row(0.fr)
        this.row(0.fr)
        this.row(0.fr)
        this.row(0.fr)
        this.row(0.fr)
        column(1.fr)
        column(1.fr)
        column(1.fr)
        column(1.fr)
        column(1.fr)
        column(1.fr)
        column(1.fr)
        column(1.fr)
    }) {
        with(MaterialTheme.colorScheme) {
            ColorBox(primary, onPrimary, "primary", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(secondary, onSecondary, "secondary", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(tertiary, onTertiary, "tertiary", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(error, onError, "error", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(primaryContainer, onPrimaryContainer, "primary container", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(secondaryContainer, onSecondaryContainer, "secondary container", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(tertiaryContainer, onTertiaryContainer, "tertiary container", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(errorContainer, onErrorContainer, "error container", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(primaryFixed, onPrimaryFixed, "primary fixed", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(secondaryFixed, onSecondaryFixed, "secondary fixed", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(tertiaryFixed, onTertiaryFixed, "tertiary fixed", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(surface, onSurface, "surface", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(primaryFixedDim, onPrimaryFixed, "primary fixed dim")
            ColorBox(primaryFixed, onPrimaryFixedVariant, "on primary fixed variant")
            ColorBox(secondaryFixedDim, onSecondaryFixed, "secondary fixed dim")
            ColorBox(secondaryFixed,onSecondaryFixedVariant, "on secondary fixed variant")
            ColorBox(tertiaryFixedDim, onTertiaryFixed, "tertiary fixed dim")
            ColorBox(tertiaryFixed, onTertiaryFixedVariant, "on tertiary fixed variant")
            ColorBox(inverseSurface, inverseOnSurface, "inverse surface", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(inversePrimary, inverseOnSurface, "inverse primary")
            ColorBox(scrim, inverseOnSurface, "scrim")
            ColorBox(surfaceDim, onSurface, "surface dim")
            ColorBox(background, onBackground, "background", modifier = Modifier.gridItem(columnSpan = 2))
            ColorBox(surfaceBright, onSurface, "surface bright")
            ColorBox(outline, inverseOnSurface, "outline")
            ColorBox(outlineVariant, onSurface, "outline variant")
            ColorBox(surfaceVariant, onSurfaceVariant, "surface variant")
            ColorBox(surfaceContainerLowest, onSurface, "surface container lowest")
            ColorBox(surfaceContainerLow, onSurface, "surface container low")
            ColorBox(surfaceContainer, onSurface, "surface container")
            ColorBox(surfaceContainerHigh, onSurface, "surface container high")
            ColorBox(surfaceContainerHighest, onSurface, "surface container highest")
            ColorBox(surfaceTint, onSurface, "surface tint")
        }
    }
}

@Preview(widthDp = 640)
@Composable
private fun ThemeColorsPreview() {
    PastelTheme() {
        ThemeColors()
    }
}