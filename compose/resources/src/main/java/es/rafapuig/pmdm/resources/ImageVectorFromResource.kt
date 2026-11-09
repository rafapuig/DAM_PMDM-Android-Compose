package es.rafapuig.pmdm.resources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ImageVectorFromResource(modifier: Modifier = Modifier) {

    val imageVector =
        ImageVector.vectorResource(R.drawable.escudo_de_espanya_360)

    Image(
        imageVector = imageVector,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}


@Preview
@Composable
fun ImageVectorFromResourcePreview() {
    ImageVectorFromResource(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.systemBars)
            .fillMaxWidth()
    )
}