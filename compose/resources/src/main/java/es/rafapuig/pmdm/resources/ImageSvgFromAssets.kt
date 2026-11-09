package es.rafapuig.pmdm.resources

import android.graphics.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.createBitmap
import androidx.core.view.WindowInsetsAnimationCompat
import com.caverock.androidsvg.SVG

@Composable
fun ImageSvgFromAssets() {

    val context = LocalContext.current

    val svg = SVG.getFromAsset(context.assets, "flags/es.svg")

    val bitmap = createBitmap(750, 500)

    svg.renderToCanvas(Canvas(bitmap))

    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}


@Preview
@Composable
fun ImageSvgFromAssetsPreview() {
    ImageSvgFromAssets()
}