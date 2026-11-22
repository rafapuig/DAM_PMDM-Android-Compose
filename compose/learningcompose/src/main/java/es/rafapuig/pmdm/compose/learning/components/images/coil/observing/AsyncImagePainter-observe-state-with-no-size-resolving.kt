package es.rafapuig.pmdm.compose.learning.components.images.coil.observing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.maxBitmapSize
import coil3.size.Size
import es.rafapuig.pmdm.compose.learning.utils.screen.getScreenSize
import kotlin.random.Random


/**
 * El límite en la API Lorem Picsum
 * es tanto para la altura como para la anchura de 5000 pixels
 * Si cualquiera de las dos dimensiones supera los 5000
 * se devuelve un error HTTP 400 con el contenido text/plain: Invalid size
 */
private const val LOREM_PICSUM_MAX_SIZE = 5_000 // pixeles

@Preview
@Composable
private fun ObserveAsyncImagePainterDemo() {

    val context = LocalContext.current

    // Obtenemos las dimensiones de la pantalla y recordarlas entre recomposiciones
    val (screenWidth, screenHeight) = remember { context.getScreenSize() }

    // Calcular el alto y el ancho de la imagen a obtener del API Lorem Picsum
    val width = LOREM_PICSUM_MAX_SIZE * screenWidth / maxOf(screenWidth, screenHeight)
    val height = LOREM_PICSUM_MAX_SIZE * screenHeight / maxOf(screenWidth, screenHeight)

    val random = remember { Random.nextInt() }

    val imageUrl = "https://picsum.photos/${width}/${height}?random=${random}"

    val painter = rememberAsyncImagePainter(
        model =  ImageRequest.Builder(context)
            .data(imageUrl)
            .maxBitmapSize(Size.ORIGINAL)
            .build()
    )

    /**
     * La propiedad state del AsyncImagePainter es un StateFlow<AsyncImagePainter.State>
     * que podemos recolectar y convertirlo en un estado observable de compose
     * El flow emitirá un nuevo valor de estado: Empty, Loading, Success, Error
     * conforme avance el proceso de carga de la imagen.
     * Esa emisión del flow hace que cambie el State de compose observable
     * y con ello produce una recomposición.
     *
     * El estado que devuelve `collectAsStateWithLifecycle` lo delegamos en la
     * variable state
     */
    val state by painter.state.collectAsStateWithLifecycle()

    when (state) {
        AsyncImagePainter.State.Empty -> Unit

        /**
         * Cuando el flow ha emitido un State.Loading porque estamos cargando la imagen
         */
        is AsyncImagePainter.State.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth * 4,
                    modifier = Modifier
                        .fillMaxSize(.5f)
                        .wrapContentSize()
                        .aspectRatio(1f)
                )
            }
        }

        /**
         * Cuando se ha cargado la imagen en el painter con éxito
         */
        is AsyncImagePainter.State.Success -> {
            Image(
                painter = (state as AsyncImagePainter.State.Success).painter,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
        }

        is AsyncImagePainter.State.Error -> {
            val error = (state as AsyncImagePainter.State.Error).result.throwable.toString()
            Text(
                error,
                color = Color.Red,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
            )
        }
    }

}