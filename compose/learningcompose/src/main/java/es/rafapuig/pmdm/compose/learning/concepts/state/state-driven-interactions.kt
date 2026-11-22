package es.rafapuig.pmdm.compose.learning.concepts.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.R

/**
 * Alternar (toggling) la visibilidad de un elemento de la UI
 */

@Preview
@Composable
fun TogglingExample() {

    /**
     * La variable showImage
     * accede al estado que controla si es visible o no una imagen
     * mediante delegación
     * El objeto estado delgado es recordado entre recomposiciones
     */
    var showImage by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { showImage = !showImage }) {
            val text = if (showImage) "Ocultar" else "Mostrar"
            Text(text = text)
        }
        /**
         * Dependiendo del valor del estado delegado en la variable
         * showImage el composable Image entra o sale de la composición
         */
        if (showImage) {
            Image(
                painter = painterResource(id = R.drawable.levante_ud_logo),
                contentDescription = null
            )
        }
    }

}