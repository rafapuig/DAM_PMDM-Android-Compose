package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.clipping_to_bounds

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.compose.learning.R

/**
 * Cuando pintamos con el modificador paint
 * podemos rebasar los límites del composable
 */

@Composable
private fun PainterWithPaintModifierOutOfBoundsDemo(
    modifier: Modifier = Modifier
) {
    Box( // Caja padre, contenedor, pone un límite de 200 dp de tamaño
        modifier = modifier
            .size(200.dp)
            .background(Color.Cyan)
    ) {
        Box(
            modifier = Modifier
                .requiredSize(280.dp) // Para que pueda superar los límites del padre
                .border(0.5.dp, Color.Yellow)
                .paint(
                    painter = painterResource(R.drawable.levante_ud),
                    contentScale = ContentScale.Fit, // Se puede expandir hasta los 280 dp
                )
        )
    }
}

@Preview
@Composable
private fun PainterDemoPreview() {
    Box( // Esta caja crea el espacio para que pueda expandirse la caja padre
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentAlignment = Alignment.Center,
    ) {
        PainterWithPaintModifierOutOfBoundsDemo()
    }
}