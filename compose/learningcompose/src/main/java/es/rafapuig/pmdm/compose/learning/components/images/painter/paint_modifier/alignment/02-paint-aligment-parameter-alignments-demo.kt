package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.alignment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.compose.learning.R

@Composable
private fun PaintModifierAlignmentDemo(
    modifier: Modifier = Modifier,
    paintAlignment: Alignment = Alignment.TopStart
) {
    Box(
        modifier = modifier
            .size(400.dp)
            .background(Color.LightGray)
            .paint(
                painter = painterResource(R.drawable.levante_ud_logo),
                contentScale = ContentScale.None,
                alignment = paintAlignment
            )
    )
}

private fun Alignment.Companion.values() =
    listOf(TopStart, TopCenter, TopEnd, CenterStart, Center, CenterEnd, BottomStart, BottomCenter, BottomEnd)



class AlignmentParameter : CollectionPreviewParameterProvider<Alignment>(
    Alignment.values()
)

@Preview
@Composable
private fun PaintAlignmentsPreview(
    @PreviewParameter(provider = AlignmentParameter::class)
    alignment: Alignment
) {
    PaintModifierAlignmentDemo(paintAlignment = alignment)
}