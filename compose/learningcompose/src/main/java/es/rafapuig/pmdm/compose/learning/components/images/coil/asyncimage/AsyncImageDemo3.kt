package es.rafapuig.pmdm.compose.learning.components.images.coil

import android.content.Context
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


private fun buildImageRequest(
    context: Context,
    block: ImageRequest.Builder.() -> Unit
) =
    ImageRequest.Builder(context).apply { block() }.build()


@Composable
private fun AsyncImageFromImageRequest(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = buildImageRequest(LocalContext.current) {
            data("") // Sin data, se usará el error painter
            crossfade(true)
        },
        placeholder = painterResource(R.drawable.movie_placeholder),
        error = painterResource(R.drawable.movie_not_available),
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