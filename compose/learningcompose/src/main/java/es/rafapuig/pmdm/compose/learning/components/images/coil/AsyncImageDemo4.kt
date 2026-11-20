package es.rafapuig.pmdm.compose.learning.components.images.coil

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
            data("")
            crossfade(true)
        },
        placeholder = painterResource(R.drawable.movie_placeholder),
        error = painterResource(R.drawable.movie_not_available),
        contentDescription = null,
        contentScale = ContentScale.Crop, // Cambiar por otros valores y comprobar
        modifier = modifier
    )
}

@Preview
@Composable
private fun AsyncImageFromImageRequestPreview() {
    AsyncImageFromImageRequest(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .clip(RoundedCornerShape(topStartPercent = 5, topEndPercent = 5))
            .background(Color.Cyan)
    )
}