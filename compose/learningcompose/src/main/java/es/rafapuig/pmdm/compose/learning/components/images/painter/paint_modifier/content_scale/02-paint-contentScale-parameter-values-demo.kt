package es.rafapuig.pmdm.compose.learning.components.images.painter.paint_modifier.content_scale

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import es.rafapuig.pmdm.compose.learning.R

/**
 * El aspect ratio de la imagen es 0,823
 */

@Composable
private fun PaintModifierContentScaleDemo(
    modifier: Modifier = Modifier,
    paintAlignment: Alignment = Alignment.Center, // Cambiar y probar
    contentScale: ContentScale = ContentScale.None
) {
    Box(
        modifier = modifier
            //.width(400.dp)
            //.height(400.dp)
            //.aspectRatio(0.823f)
            .background(Color.LightGray)
            .paint(
                painter = painterResource(R.drawable.levante_ud),
                contentScale = contentScale,
                alignment = paintAlignment
            )
    )
}


private fun ContentScale.Companion.values() =
    listOf(None, Inside, Fit, FillWidth, FillHeight, FillBounds, Crop)


class ContentScaleParameter : CollectionPreviewParameterProvider<ContentScale>(
    ContentScale.values()
)

@Preview(name = "mas alto", widthDp = 400, heightDp = 800)
@Preview(name = "mas ancho", widthDp = 800, heightDp = 400)
@Preview(name = "cuadrado", widthDp = 400, heightDp = 400)
@Preview(name = "mas grande", widthDp = 900, heightDp = 1100)
@Composable
private fun PaintContentScalesPreview(
    @PreviewParameter(provider = ContentScaleParameter::class)
    contentScale: ContentScale
) {
    PaintModifierContentScaleDemo(contentScale = contentScale)
}