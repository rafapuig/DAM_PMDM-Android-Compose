package es.rafapuig.pmdm.compose.learning.components.images.image.vector

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.R

@Preview(showBackground = true)
@Composable
private fun ImageVectorFromResourceDemo(modifier: Modifier = Modifier) {

    val imageVector =
        ImageVector.vectorResource(R.drawable.spain_badge)

    Image(
        imageVector = imageVector,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
private fun ImageVectorFromResourceDemo128(modifier: Modifier = Modifier) {

    val imageVector =
        ImageVector.vectorResource(R.drawable.spain_badge_128)

    Image(
        imageVector = imageVector,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
private fun ImageVectorFromResourceDemo2(modifier: Modifier = Modifier) {

    val imageVector =
        ImageVector.vectorResource(R.drawable.spain_badge_64)

    Image(
        imageVector = imageVector,
        contentDescription = null
    )
}