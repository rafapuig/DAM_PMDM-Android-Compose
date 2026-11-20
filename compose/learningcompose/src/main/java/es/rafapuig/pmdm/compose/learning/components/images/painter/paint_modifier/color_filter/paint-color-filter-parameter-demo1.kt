package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.color_filter

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.R

@Composable
private fun PaintModifierColorFilterDemo(
    modifier: Modifier = Modifier
) {
    val painter = painterResource(R.drawable.levante_ud)

    Box(
        modifier = modifier
            .paint(
                painter = painter,
                colorFilter = ColorFilter.tint(Color.Green, BlendMode.ColorBurn)
            )
    )
}


@Preview(showBackground = true)
@Composable
private fun PaintModifierColorFilterDemoPreview() {
    PaintModifierColorFilterDemo()
}