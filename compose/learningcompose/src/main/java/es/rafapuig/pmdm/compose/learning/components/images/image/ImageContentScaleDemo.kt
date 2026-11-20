package es.rafapuig.pmdm.compose.learning.components.images.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.compose.learning.R

class ContentScaleProvider : PreviewParameterProvider<ContentScale> {
    override val values: Sequence<ContentScale>
        get() = with(ContentScale) {
            sequenceOf(
                None, // No se ajusta
                Inside, // Solo se ajusta si es más grande que el destino
                Fit, // Se ajusta al destino (wh < dest)
                FillHeight, // Se ajusta en alto (puede recortar por lados si es muy ancha)
                FillWidth, // Se ajusta en ancho (puede recortar por arriba y abajo si el muy larga)
                FillBounds, // Se ajusta al destino (no mantiene relación aspecto)
                Crop, // Se ajusta a la dimensión más larga
            )
        }
}

@Preview(showBackground = true)
@Composable
fun ImageContentScaleDemoScreen(
    @PreviewParameter(ContentScaleProvider::class)
    contentScale: ContentScale
) {

    val painter = painterResource(id = R.drawable.real_sociedad)

    Column {
        val boxModifier =
            Modifier
                .border(2.dp, Color.Black)
                .fillMaxWidth()

        val imageAlignment = Alignment.Center // Cambiar para ver efecto

        Box(modifier = boxModifier.weight(1f)) {
            Image(
                painter = painter,
                contentDescription = "Escudo",
                modifier = Modifier.fillMaxSize(),
                contentScale = contentScale,
                alignment = imageAlignment
            )
        }

        Box(modifier = boxModifier.weight(3f)) {
            Image(
                painter = painter,
                contentDescription = "Escudo",
                modifier = Modifier.fillMaxSize(),
                contentScale = contentScale,
                alignment = imageAlignment
            )
        }
    }

}