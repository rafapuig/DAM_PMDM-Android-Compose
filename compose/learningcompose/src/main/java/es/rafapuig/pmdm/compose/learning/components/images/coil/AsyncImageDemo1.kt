package es.rafapuig.pmdm.compose.learning.components.images.coil

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest

@Composable
private fun AsyncImageFromImageRequest(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://picsum.photos/1000")
            .build(),
        contentDescription = null,
        modifier = modifier
    )
}


@Preview
@Composable
private fun AsyncImageFromImageRequestPreview() {
    AsyncImageFromImageRequest(
        modifier = Modifier.systemBarsPadding()
    )
}