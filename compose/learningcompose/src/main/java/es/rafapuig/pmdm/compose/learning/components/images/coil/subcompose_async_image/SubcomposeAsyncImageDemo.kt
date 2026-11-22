package es.rafapuig.pmdm.compose.learning.components.images.coil.subcompose_async_image

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import kotlin.random.Random

@Preview
@Composable
fun SubcomposeAsyncImageDemo(modifier: Modifier = Modifier) {

    val isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT

    SubcomposeAsyncImage(
        model = "https://picsum.photos/5000?random=${Random.nextInt()}" ,
        contentDescription = "",
        loading = {
            Box(modifier = Modifier
                .border(2.dp, color = MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth * 3,
                    modifier = Modifier.fillMaxSize(.33f)
                )
            }
        },
        modifier = Modifier
            .then(if(isPortrait) Modifier.systemBarsPadding() else Modifier)
            .fillMaxSize()
            .wrapContentSize()
            .background(Color.LightGray)
            .aspectRatio(1f)
    )
}