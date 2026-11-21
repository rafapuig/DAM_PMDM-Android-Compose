package es.rafapuig.pmdm.compose.learning.components.images.coil

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import es.rafapuig.pmdm.compose.learning.components.images.coil.preview.AsyncImageWithPreview

/**
 * https://coil-kt.github.io/coil/compose/#asyncimage
 *
 * AsyncImage es un composable
 * que ejecuta una solicitud de imagen de forma asíncrona
 * y muestra el resultado.
 * Admite los mismos argumentos que el composable Image estándar.
 *
 * Se puede usar como model
 * - el valor del ImageRequest.data
 * - un ImageRequest
 */

@Composable
fun CoilNetworkImage(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = "https://picsum.photos/id/20/800",
        contentDescription = null,
        modifier = modifier
    )
}

@Preview
@Composable
private fun CoilNetworkImageDemoPreview() {
    AsyncImageWithPreview {
        CoilNetworkImage()
    }
}