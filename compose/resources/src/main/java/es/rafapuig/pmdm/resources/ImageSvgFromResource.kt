package es.rafapuig.pmdm.resources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ImageSvgFromResource(modifier: Modifier = Modifier) {

    val painter = painterResource(R.drawable.flag_es)

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = modifier
    )
}


@Preview
@Composable
fun ImageSvgFromResourcePreview() {
    ImageSvgFromResource(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.systemBars)
            .fillMaxWidth()
    )
}