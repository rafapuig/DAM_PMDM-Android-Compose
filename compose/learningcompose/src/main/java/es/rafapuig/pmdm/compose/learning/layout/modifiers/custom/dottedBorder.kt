package es.rafapuig.pmdm.compose.learning.layout.modifiers.custom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.dottedBorder(
    width: Dp = 2.dp,
    color: Color = Color.Gray,
    dotSpacing: Dp = 6.dp,
    shape: Shape = RectangleShape
) = drawBehind {
    val stroke = Stroke(
        width = width.toPx(),
        cap = StrokeCap.Round,
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(
                0f,
                dotSpacing.toPx()
            )
        )
    )

    drawOutline(
        outline = shape.createOutline(
            size = size,
            layoutDirection = layoutDirection,
            density = this
        ),
        color = color,
        style = stroke
    )
}

@Preview
@Composable
private fun RectangularBorderPreview() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .dottedBorder(
                width = 2.dp,
                color = Color.Red,
                dotSpacing = 8.dp
            )
    )
}

@Preview
@Composable
private fun RoundedBorderPreview() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .dottedBorder(
                width = 2.dp,
                color = Color.Blue,
                dotSpacing = 8.dp,
                shape = RoundedCornerShape(16.dp)
            )
    )
}

@Preview
@Composable
private fun CircleBorderPreview() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .dottedBorder(
                width = 2.dp,
                color = Color.Green,
                dotSpacing = 8.dp,
                shape = CircleShape
            )
    )
}