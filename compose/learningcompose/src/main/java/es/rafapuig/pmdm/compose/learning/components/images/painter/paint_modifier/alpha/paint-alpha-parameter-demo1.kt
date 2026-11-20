package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.alpha

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.R


@Composable
private fun PaintModifierAlphaDemo(
    modifier: Modifier = Modifier
) {
    val painter = painterResource(R.drawable.levante_ud)

    Box(
        modifier = modifier
            .paint(
                painter = painter,
                alpha = 0.5f
            )
    )
}


@Preview(showBackground = true)
@Composable
private fun PaintModifierAlphaDemoPreview() {
    PaintModifierAlphaDemo(
        modifier = Modifier.background(Color.Magenta.copy(alpha = 0.15f))
    )
}