package es.rafapuig.pmdm.compose.learning.layout.modifiers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Modificadores (Modifier)
 * https://developer.android.com/develop/ui/compose/modifiers
 *
 * Permiten personalizar la apariencia y el comportamiento de un composable.
 * Nos permiten, "decorarlo": adornarlo o ampliarlo.
 *
 * La mayoría de los built-in composables declaran un parámetro de tipo Modifier
 *
 * Modifier es una interface de Compose
 * La interface declara un companion object que implementa la propía interface
 * y proporciona una gran cantidad de métodos para configurar
 * propiedades tales como bordes, padding, background, size, gestos, clics, etc.
 *
 */

val theBasicModifier = Modifier.Companion

/**
 * Podemos crear un modificador llamando a una de las funciones del objeto Companion de Modifier
 */

val modifier1 = Modifier.Companion.padding(24.dp)

/**
 * Como vemos,
 * no es necesario hacer explícito el acceso al objeto companion de la interface Modifier
 */

val modifier2 = Modifier.padding(24.dp)

/**
 * Los modificadores se pueden encadenar,
 * puesto que la función devuelve un nuevo modificador basado en el modificador usado como receptor
 * decorado con el efecto producido por la función
 */

val modifier3 = Modifier
    .padding(24.dp)
    .fillMaxWidth()

val modifier4 = modifier2.fillMaxWidth()

/**
 * EL ORDEN DE APLICACIÓN DE LOS MODIFICADORES IMPORTA
 * La secuencia de modificadores es importante dado que los modificadores se aplican en ese orden,
 * lo cual puede afectar al resultado final
 */

// Aquí toda el área de composable al que se aplique sería clickable
val allAreaClickableModifier = Modifier
    .clickable(onClick = {})
    .padding(48.dp)

// Aquí solamente el área dentro del relleno (la zona de relleno no sería clickable)
val onlyInnerAreaClickableModifier = Modifier
    .padding(48.dp)
    .clickable(onClick = {})

/**
 * Compose proporciona una larga lista de modificadores integrados
 */


/**
 * Parent data modifiers:
 *
 * Algunos modificadores solamente se pueden aplicar a los composables hijos de ciertos composables.
 *
 * Por ejemplo,
 *  - matchParentSize solamente se puede aplicar a hijos de un Box o BoxWithConstrains.
 *  - weight en Row y Column
 *
 * Para forzar que esto se cumple, estos modificadores son declarados como métodos de extension.
 * En el ejemplo, matchParentSize se declara como miembro de la clase Modifier
 */

val BoxScope.scopedModifier get() = Modifier.matchParentSize()