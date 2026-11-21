package es.rafapuig.pmdm.compose.learning.components.images.coil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

class OverflowPainter : Painter() {

    override val intrinsicSize = Size.Unspecified

    override fun DrawScope.onDraw() {
        drawRect(
            color = Color.Red,
            topLeft = Offset(+60f, +60f),
            size = Size(size.width +30f, size.height + 15f)
        )
    }
}


@Composable
fun ClipToBoundsExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(32.dp),
        horizontalArrangement = Arrangement
            .spacedBy(100.dp, Alignment.CenterHorizontally)
    ) {
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Gray)
        ) {
            AsyncImage(
                model = null,
                contentDescription = null,
                fallback = OverflowPainter(),
                clipToBounds = true,
                modifier = Modifier.fillMaxSize()
            )
        }

        Box(
            Modifier
                .size(100.dp)
                .background(Color.Gray)
        ) {
            AsyncImage(
                model = null,
                contentDescription = null,
                fallback = OverflowPainter(),
                clipToBounds = false,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Preview
@Composable
private fun ClipToBoundsExamplePreview() {
    ClipToBoundsExample(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxWidth()
            //.size(400.dp)

    )
}