package es.rafapuig.pmdm.compose.learning.components.images.painter

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.R


@Composable
private fun PainterWithPaintModifierInBoxDemo(
    modifier: Modifier = Modifier
) {
    val painter = painterResource(R.drawable.levante_ud_logo)

    Box(modifier = modifier.paint(painter = painter))
}


@Preview
@Composable
private fun PainterWithPaintModifierInBoxDemoPreview() {
    PainterWithPaintModifierInBoxDemo()
}