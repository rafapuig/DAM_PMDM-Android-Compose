package es.rafapuig.pmdm.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder

@Composable
fun ImageSvgFromAssetsWithCoil() {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("file:///android_asset/flags/es.svg")
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = "Spain Flag",
        contentScale = ContentScale.Crop
    )
}


@Preview
@Composable
fun ImageSvgFromAssetsWithCoilPreview() {
    ImageSvgFromAssetsWithCoil()
}