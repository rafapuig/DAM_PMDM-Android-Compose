package es.rafapuig.pmdm.compose.learning.components.images.image

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.compose.learning.R

@Preview
@Composable
private fun ImageVectorDemo(modifier: Modifier = Modifier) {

    Image(
        imageVector = Icons.Default.AccountBox,
        contentDescription = null
    )
}


@Preview
@Composable
private fun ImageVectorDemo2(modifier: Modifier = Modifier) {

    val imageVector =
        ImageVector.vectorResource(R.drawable.spain_badge)

    Image(
        imageVector = imageVector,
        contentDescription = null
    )
}

@Preview
@Composable
private fun ImageVectorDemo3() {

    val homeIcon = ImageVector.Builder(
        name = "Home",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(
            fill = SolidColor(Color.Red)
        ) {
            moveTo(12f, 3f)
            lineTo(2f, 12f)
            lineTo(4f, 12f)
            lineTo(4f, 21f)
            lineTo(10f, 21f)
            lineTo(10f, 14f)
            lineTo(14f, 14f)
            lineTo(14f, 21f)
            lineTo(20f, 21f)
            lineTo(20f, 12f)
            lineTo(22f, 12f)
            close()
        }
    }.build()

    Image(
        imageVector = homeIcon,
        contentDescription = null
    )
}