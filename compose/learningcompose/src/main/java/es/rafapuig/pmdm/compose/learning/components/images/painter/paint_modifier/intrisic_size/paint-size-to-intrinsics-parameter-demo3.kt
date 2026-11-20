package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.intrisic_size

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

private class CustomPainterDensity(
    private val density: Density
) : Painter() {

    override val intrinsicSize: Size
        get() = with(density) {
            val widthPx = 200.dp.toPx()
            val heightPx = 100.dp.toPx()
            Size(widthPx, heightPx)
        }

    /**
     * Tenemos acceso a DrawScope cuando implementamos onDraw
     */
    override fun DrawScope.onDraw() {
        drawCircle(
            //center = center,
            color = Color.Blue,
            radius = size.minDimension / 2f
        )
    }
}


@Preview
@Composable
private fun PaintToIntrinsicsTrueWithUnboundPreview() {

    val density = LocalDensity.current

    val painter = remember(density) {
        CustomPainterDensity(density)
    }

    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp)
            .background(Color.Cyan)
            .paint(painter)
    )
}

/**
 * Toma el ancho y alto de su contenedor 200 x WidthDP
 */
@Preview(heightDp = 200)
@Composable
private fun PaintToIntrinsicsFalse() {

    val density = LocalDensity.current

    val painter = remember(density) {
        CustomPainterDensity(density)
    }

    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp)
            .background(Color.Cyan)
            .paint(
                painter = painter,
                sizeToIntrinsics = false // Toma el tamaño del Box (la previa)
            )
    )
}

/**
 * Toma el alto del límite
 * y al ancho no establecido de la medida de ancho intrínseca del painter
 */
@Preview(heightDp = 200)
@Composable
private fun PaintToIntrinsicsTrueWithUnboundWidth() {

    val density = LocalDensity.current

    val painter = remember(density) {
        CustomPainterDensity(density)
    }

    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp)
            .background(Color.Cyan)
            .paint(
                painter = painter,
                sizeToIntrinsics = true // Toma el ancho del painter
            )
    )
}