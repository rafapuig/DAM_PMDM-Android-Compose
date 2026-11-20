package es.rafapuig.pmdm.compose.learning.components.images.coil.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler


@Composable
fun MyAsyncImage(modifier: Modifier = Modifier) {
    AsyncImage(
        model = "https://picsum.photos/id/20/800",
        contentDescription = null,
        modifier = modifier
    )
}


@OptIn(ExperimentalCoilApi::class)
@Preview
@Composable
private fun AsyncImagePreviewDemoPreview() {

    val previewHandler = remember {
        AsyncImagePreviewHandler {
            ColorImage(Color.Red.toArgb())
        }
    }

    CompositionLocalProvider(
        LocalAsyncImagePreviewHandler
                provides previewHandler
    ) {
        MyAsyncImage()
    }
}