package es.rafapuig.pmdm.compose.learning.components.images.coil.remember_async_image_painter

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.getSystemService
import coil3.compose.rememberAsyncImagePainter
import es.rafapuig.pmdm.compose.learning.TAG
import kotlin.random.Random

/**
 * Obtiene el valor del ancho y el alto en pixels de la pantalla
 * del dispositivo
 */
private fun Context.getScreenSize(): Pair<Int, Int> {
    val windowManager = this.getSystemService<WindowManager>()!!

    // Si estamos compilando para uan version igual o superior a 30
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val bounds = windowManager.currentWindowMetrics.bounds
        bounds.width() to bounds.height()
    } else { // Si no utilizamos el API antigua
        val displayMetrics = DisplayMetrics()
        @Suppress("DEPRECATION")
        windowManager.defaultDisplay.getRealMetrics(displayMetrics)
        displayMetrics.widthPixels to displayMetrics.heightPixels
    }
}

@Preview
@Composable
private fun RememberAsyncImagePainterDemo() {

    val context = LocalContext.current

    // Obtener el tamaño en pixels de la pantalla del dispositivo
    /**
     * Al usar remember solamente se calculan en la composición
     * (y cuando, cambia la configuración del dispositivo ->
     * un cambio de configuración produce de nuevo una composición)
     */
    val (width, height) = remember {
        Log.i(TAG, "Calculo de las dimensiones de la pantalla...")
        context.getScreenSize().apply {
            Log.i(TAG, "Ancho: $first, Alto:$second")
        }
    }

    val painter = rememberAsyncImagePainter(
        model = "https://picsum.photos/${width}/${height}?random=${Random.nextInt()}"
    )

    Image(
        painter = painter,
        contentDescription = null
    )
}