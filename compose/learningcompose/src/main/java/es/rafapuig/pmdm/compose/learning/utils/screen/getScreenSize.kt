package es.rafapuig.pmdm.compose.learning.utils.screen

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.core.content.getSystemService

/**
 * Obtiene el valor del ancho y el alto en pixels de la pantalla
 * del dispositivo
 */
fun Context.getScreenSize(): Pair<Int, Int> {
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