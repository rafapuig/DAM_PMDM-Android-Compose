package es.rafapuig.pmdm.compose.learning.components.images.coil

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import kotlin.random.Random


val imageURL = "https://picsum.photos/1220?random=" /*"https://raw.githubusercontent.com/rafapuig/" +
        "PMDM-Android-Compose/refs/heads/master/learningcompose/" +
        "src/main/res/drawable/vacation.jpg" */

@Preview
@Composable
fun NetworkImageDemo() {

    val imageURL = "https://picsum.photos/1220?random=${Random.nextInt()}"

    val painter = rememberAsyncImagePainter(
        model = imageURL
    )

    RowOrColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painter,
            contentDescription = "Lorem Picsum"
        )

        AsyncImage(
            model = imageURL,
            contentDescription = "Lorem Picsum",
            onError = {
                it.result.throwable.printStackTrace()
            }
        )
    }
}

@Composable
fun RowOrColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val isLandscape = LocalConfiguration.current
        .orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            content()
        }
    } else {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center
        ) {
            content()
        }
    }

}
