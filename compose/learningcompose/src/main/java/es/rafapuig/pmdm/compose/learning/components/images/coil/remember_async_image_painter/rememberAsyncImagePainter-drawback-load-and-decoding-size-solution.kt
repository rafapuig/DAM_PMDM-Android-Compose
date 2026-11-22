package es.rafapuig.pmdm.compose.learning.components.images.coil.remember_async_image_painter

import android.util.Log
import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.isSpecified
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImagePainter
import coil3.compose.ConstraintsSizeResolver
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.maxBitmapSize
import coil3.size.Dimension
import coil3.size.Size
import es.rafapuig.pmdm.compose.learning.TAG
import es.rafapuig.pmdm.compose.learning.utils.screen.getScreenSize
import kotlin.random.Random

/**
 * El principal problema de usar `rememberAsyncImagePainter`
 * es que no detecta el tamaño con el cual se quiere pintar la imagen
 * en la pantalla y, por tanto, siempre la carga en la memoria con
 * su tamaño original
 * (con el que originalmente fue descargada o tiene el archivo en disco).
 * Es decir, usa el tamaño original para su decodificación.
 *
 * En este ejemplo, vamos a hacer que se descargue la imagen más pesado posible
 * desde el servidor y que Coil la decodifique a su tamaño original
 */

/**
 * El límite en la API Lorem Picsum
 * es tanto para la altura como para la anchura de 5000 pixels
 * Si cualquiera de las dos dimensiones supera los 5000
 * se devuelve un error HTTP 400 con el contenido text/plain: Invalid size
 */
private const val LOREM_PICSUM_MAX_SIZE = 5_000 // pixeles

@Preview
@Composable
private fun RememberAsyncImagePainterDemo() {

    var isLoading by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }

    val context = LocalContext.current

    // Obtenemos las dimensiones de la pantalla y recordarlas entre recomposiciones
    val (screenWidth, screenHeight) = remember { context.getScreenSize() }

    // Calcular el alto y el anho de la imagen a obtener del API Lorem Picsum
    /**
     * Si la pantalla es más ancha que larga (landscape) el ancho será el máximo y el alto proporcional
     * Si la es más larga que ancha (portrait) el alto será el máximo y el ancho proporcional
     */
    val width = LOREM_PICSUM_MAX_SIZE * screenWidth / maxOf(screenWidth, screenHeight)
    val height = LOREM_PICSUM_MAX_SIZE * screenHeight / maxOf(screenWidth, screenHeight)


    /**
     * El número aleatorio hay que recordarlo entre recomposiciones
     * (si no cada recomposición fuerza una nueva carga de imagen
     * porque el número aleatorio generado en la recomposición será diferente)
     */
    val random = remember { Random.nextInt() }

    /**
     * Se reconstruye en cada recomposición, pero es una operación trivial (barata)
     * y sus dependencias: width y height nunca cambian, y random ya está memorizado
     */
    val imageUrl = "https://picsum.photos/${width}/${height}?random=${random}"


    /**
     * 1. Creamos un ConstraintsSizeResolver
     */
    val sizeResolver = remember {
        ConstraintsSizeResolver()
    }

    /**
     * Tenemos que utilizar una ImageRequest de Coil porque
     * queremos modificar el tamaño máximo del Bitmap que se codifica en memoria,
     * no queremos que haya un máximo
     * El cálculo de la solicitud depende la imageUrl,
     * lo memorizamos mientras no cambie en las recomposiciones
     */
    val request = remember(imageUrl) {
        ImageRequest.Builder(context)
            .data(imageUrl)
            /**
             * 2. Se lo proporcionamos al ImageRequest
             */
            .size(sizeResolver)
            /**
             * Por defecto, Coil decodifica bitmaps a un máximo de 4096 píxeles
             * Si queremos podemos modificar ese tamaño límite
             * y también podemos decir, que use el tamaño original de la imagen fuente
             */
            //.maxBitmapSize(Size(LOREM_PICSUM_MAX_SIZE,LOREM_PICSUM_MAX_SIZE))
            .maxBitmapSize(Size(Dimension.Undefined, Dimension.Undefined))
            //.maxBitmapSize(Size.ORIGINAL)
            .build()
    }

    val painter = rememberAsyncImagePainter(
        model = request
    )

    val state by painter.state.collectAsStateWithLifecycle()

    LaunchedEffect(state) {
        when (state) {
            is AsyncImagePainter.State.Success -> {
                isLoading = false

                val image = (state as AsyncImagePainter.State.Success).result.image

                val w = image.width
                val h = image.height

                val imageSize = state.painter!!.intrinsicSize

                val width = imageSize.width
                val height = imageSize.height

                Log.d(TAG, "Painter: $width x $height, Image: $w x $h")
            }

            //else -> Unit
            AsyncImagePainter.State.Empty -> {
                isLoading = false
                isError = false
            }

            is AsyncImagePainter.State.Error -> {
                error = (state as AsyncImagePainter.State.Error).result.throwable.toString()
                isLoading = false
                isError = true
            }

            is AsyncImagePainter.State.Loading -> {
                isLoading = true
            }
        }
    }

    if (isLoading) {
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

    if (isError) {
        Text(
            error,
            color = Color.Red,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(),
        )
    }

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            //.systemBarsPadding()
            .fillMaxWidth(.5f)
            /**
             * 3. Añadimos el mismo sizeResolver como modificador del Image
             * 4. El resolver recibe las restricciones de medida del Image
             * 5. Y Coil utiliza esas dimensiones para decidir a qué tamaño decodifica la imagen
             */
            .then(sizeResolver)
    )
}