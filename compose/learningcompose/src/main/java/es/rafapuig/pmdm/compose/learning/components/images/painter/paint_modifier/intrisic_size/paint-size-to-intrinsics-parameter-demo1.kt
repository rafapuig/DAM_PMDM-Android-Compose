package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.intrisic_size

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private class CustomPainter : Painter() {

    override val intrinsicSize: Size
        get() = Size(600f, 300f) //Size.Unspecified // Size(300f, 300f)


    override fun DrawScope.onDraw() {

        /**
         * Tenemos acceso a DrawScope cuando implementamos onDraw
         */
        val widthPx = 100.dp.toPx()
        val heightPx = 100.dp.toPx()

        val sized = Size(widthPx, heightPx)

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
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp)
            .background(Color.Cyan)
            .paint(
                CustomPainter()
            )
    )
}

/**
 * Toma el ancho y alto de su contenedor 200 x WidthDP
 */
@Preview(heightDp = 200)
@Composable
private fun PaintToIntrinsicsFalse() {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp)
            .background(Color.Cyan)
            .paint(
                CustomPainter(),
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
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp)
            .background(Color.Cyan)
            .paint(
                CustomPainter(),
                sizeToIntrinsics = true // Toma el ancho del painter
            )
    )
}