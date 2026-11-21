package es.rafapuig.pmdm.compose.learning.components.images.coil.remember_async_image_painter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.rememberAsyncImagePainter
import kotlin.random.Random

/**
 * Internamente, `AsyncImage` y `SubcomposeAsyncImage` usan  *
 * `rememberAsyncImagePainter` para cargar el modelo.
 *
 * Si necesitamos un Painter en lugar de un composable
 * podemos cargar la imagen mediante `rememberAsyncImagePainter`. *
 */

@Preview
@Composable
private fun RememberAsyncImagePainterDemo() {

    val width = 1220 / 2
    val height = 2712 / 2

    val painter = rememberAsyncImagePainter(
        model = "https://picsum.photos/${width}/${height}?random=${Random.nextInt()}"
    )

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
        .systemBarsPadding()
        .fillMaxWidth()
    )
}