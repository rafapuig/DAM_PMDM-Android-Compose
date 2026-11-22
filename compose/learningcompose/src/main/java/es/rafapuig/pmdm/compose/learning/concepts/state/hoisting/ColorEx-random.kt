package es.rafapuig.pmdm.compose.learning.concepts.state.hoisting

import androidx.compose.ui.graphics.Color
import kotlin.random.Random
import kotlin.random.Random.Default.nextFloat

/**
 * Función de extensión de la clase Color para generar un color aleatorio
 * La función se usa como si fuera un miembro estático de la clase Color,
 * ya que estamos usando como receptor el objeto companion de la clase Color
 */
fun Color.Companion.random() =
    with(Random.Default) {
        Color(
            red = nextFloat(),
            green = nextFloat(),
            blue = nextFloat(),
            1f
        )
    }