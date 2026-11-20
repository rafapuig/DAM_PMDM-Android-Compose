package es.rafapuig.pmdm.compose.learning.components.images.image.vector

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ImageVectorFromIconsDemo(modifier: Modifier = Modifier) {

    Image(
        imageVector = Icons.Default.AccountBox,
        contentDescription = null
    )
}