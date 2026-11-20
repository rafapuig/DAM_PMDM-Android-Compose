package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.alpha

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import es.rafapuig.pmdm.compose.learning.R


@Composable
private fun PaintModifierAlphaDemo(
    modifier: Modifier = Modifier,
    alpha: Float = 1f
) {
    val painter = painterResource(R.drawable.levante_ud_logo)

    Box(
        modifier = modifier
            .paint(
                painter = painter,
                alpha = alpha
            )
    )
}

class AlphaParameter : PreviewParameterProvider<Float> {
    override val values: Sequence<Float>
        get() = generateSequence(0f) { it + 0.1f }
            .takeWhile { it <= 1f }
            .sortedDescending()
            //generateSequence(10) { it - 1 }
            //.takeWhile { it >= 0 }.map { it / 10f }
}


@Preview(showBackground = true)
@Composable
private fun PaintModifierAlphaDemoPreview(
    @PreviewParameter(AlphaParameter::class)
    alpha: Float
) {
    PaintModifierAlphaDemo(
        alpha = alpha,
        modifier = Modifier.background(Color.Cyan.copy(alpha = 0.2f))
    )
}