package es.rafapuig.pmdm.compose.learning.components.images.coil.preview

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalResources
import coil3.annotation.ExperimentalCoilApi
import coil3.asImage
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import es.rafapuig.pmdm.compose.learning.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun AsyncImageWithPreview(
    @DrawableRes drawableResId: Int = R.drawable.levante_ud,
    content: @Composable () -> Unit
) {
    val resources = LocalResources.current

    val previewHandler =
        remember(drawableResId) {
            AsyncImagePreviewHandler {
                resources
                    .getDrawable(drawableResId, null)
                    .asImage()
            }
        }

    CompositionLocalProvider(
        LocalAsyncImagePreviewHandler
                provides previewHandler
    ) {
        content()
    }
}