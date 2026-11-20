package es.rafapuig.pmdm.compose.learning.components.images.coil.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage


@Composable
fun AsyncImageWithPreviewDemo(
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
private fun AsyncImageWithPreviewDemoPreview() {
    AsyncImageWithPreview {
        AsyncImageWithPreviewDemo()
    }
}


