package es.rafapuig.pmdm.compose.learning.concepts.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Estados de Compose State<T> y MutableState<T>
 *
 * En Compose un estado es un valor que puede cambiar a lo largo del tiempo
 *
 * https://developer.android.com/develop/ui/compose/state
 *
 * Son objetos que almacenan un valor y que son observables
 * para reaccionar a los cambios del valor que almacenan
 * Un cambio del valor almacenado por el objeto State lo llamaremos cambio de estado
 */

/**
 * Para crear un objeto estado que pueda cambiar (mutable)
 * no se usa el constructor
 * se usa la función factoría mutableStateOf
 * proporcionando el valor inicial del estado
 * y que nos fabrica un objeto MutableState<Tipo-de-valor> genérico
 */

val enabledState = mutableStateOf(false)

val loadingState = mutableStateOf(true)

val passwordState = mutableStateOf("")

/**
 * Para el caso de valores enteros es más eficiente utilizar
 * la función factoría mutableIntStateOf
 * que fabrica un MutableIntState
 */

val counterState = mutableIntStateOf(0)

/**
 * Para los valores de tipo float existe
 * la función factoría mutableFloatStateOf
 */

val sliderState = mutableFloatStateOf(50f)

/**
 * Además de estas existen:
 * - mutableLongStateOf para valores de tipo Long
 * - mutableDoubleStateOf para valores de tipo Double
 */

/**
 * Para el caso de colecciones como listas, mapas y conjuntos
 * contamos con otras funciones factoría específicas
 */

val numbersState = mutableStateListOf(1, 2, 3)

val daysState = mutableStateSetOf("lunes", "miércoles", "viernes")

val countryToCapital =
    mutableStateMapOf("España" to "Madrid", "Italia" to "Roma", "Francia" to "Paris")


fun test() {
    // Cambiar el valor del estado mediante la propiedad value
    enabledState.value = true
    passwordState.value = "Danone"

    // Para estados de valor entero usamos intValue para evitar boxing y unboxing
    counterState.intValue = 1

    // Para estado de valor float usamos floatValue para evitar boxing y unboxing
    sliderState.floatValue = 1f

    // Realizar operaciones que modifiquen el número de elementos de la colección
    // o cambiar elementos por otros producen un cambio de estado
    numbersState.add(5)
    numbersState += 6
    numbersState.remove(2)
    numbersState -= 1

    daysState.add("domingo")

    countryToCapital["Portugal"] = "Lisboa"
    countryToCapital -= "Portugal"
    countryToCapital += "Alemania" to "Berlin"
}

/**
 * Cualquier función composable que lea (observe) el valor de un estado de Compose
 * es llamada de nuevo por el runtime de Compose cuando se produce un cambio en ese estado
 * para se vuelva a generar el pedazo de UI del que se encarga la función
 * teniendo el nuevo valor del estado
 * Este fenómeno se denomina recomposición
 */

@Preview
@Composable
fun MyEnabledStateReader() {
    Switch(
        checked = enabledState.value,
        onCheckedChange = { newValue -> enabledState.value = newValue }
    )
}

@Preview
@Composable
fun MyPasswordStateReader() {
    TextField(
        value = passwordState.value, // lee el valor del estado passwordState
        onValueChange = { passwordState.value = it }
    )
}

@Preview(showBackground = true)
@Composable
fun MyCounterStateReader() {
    Text(
        modifier = Modifier.clickable { counterState.intValue++ },
        text = "Contador: ${counterState.intValue}"
    )
}

@Preview(showBackground = true)
@Composable
fun MyNumbersStateReader() {
    Column {
        numbersState.forEach {
            Text(it.toString())
            HorizontalDivider()
        }
        Button(
            onClick = {
                val next = numbersState.last() + 1
                numbersState.add(next)
            }
        ) {
            Text("Añadir numero")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyMapStateReader() {
    Column {
        countryToCapital.forEach {
            Row {
                Text(it.key)
                Text(" - ")
                Text(it.value)
            }
            HorizontalDivider()
        }
        Button(
            onClick = {
                countryToCapital += "Alemania" to "Berlín"
            }
        ) {
            Text("Añadir Alemania")
        }
    }
}