package es.rafapuig.pmdm.compose.learning.concepts.configuration


import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.ui.theme.pastel.PastelTheme

/**
 * La función `remember`
 * permite recordar el valor de los estados entre recomposiciones
 *
 * Pero NO retiene el estado entre cambios de configuración
 * (El ejemplo típico de cambio de configuración es la rotación
 * y cambio de orientación del dispositivo)
 *
 * Porque estos cambios provocan la destrucción de la actividad
 * y vuelta a recrearla desde cero
 * (Se crea una nueva instancia de objeto Activity)
 *
 * La solucion es sencilla, sin embargo, consiste en usar la
 * función `rememberSaveable` en lugar de remember
 */

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ConfigurationChangesDemoScreenPreview() {
    ConfigurationChangesDemoScreen()
}

@Composable
fun ConfigurationChangesDemoScreen() {
    PastelTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ConfigurationChangesDemoScreenContent(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun ConfigurationChangesDemoScreenContent(modifier: Modifier = Modifier) {
    Box(modifier) {
        MyTextField()
    }
}

@Composable
fun MyTextField() {
    /**
     * Utilizamos la delegación de propiedades (uso de by)
     * para simplificar el acceso al valor del estado
     * (Ahora rememberedText es una propiedad String delegada en el MutableState)
     */
    var rememberedText by rememberSaveable { mutableStateOf("") }

    val onTextChange = { newText: String ->
        rememberedText = newText // Al settear el valor se actualiza el estado mediante el delegado
    }

    TextField(
        value = rememberedText, // Al obtener el valor se lee el estado mediante el delegado
        onValueChange = onTextChange
    )
}