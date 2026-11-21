package es.rafapuig.pmdm.compose.learning.components.images.coil

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import es.rafapuig.pmdm.compose.learning.R


@Composable
private fun AsyncImageFromImageRequest(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).apply {
            data("https://picsum.photos/id/20/400")
            crossfade(true)
        }.build(),
        placeholder = painterResource(R.drawable.movie_placeholder),
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