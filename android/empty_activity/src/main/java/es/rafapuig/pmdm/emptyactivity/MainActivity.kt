package es.rafapuig.pmdm.emptyactivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.emptyactivity.ui.theme.PMDMComposeTheme

/**
 * La clase de la actividad debe estar declarada
 * en el manifiesto de la aplicación
 * AndroidManifest.xml
 *
 * Si pulsas en el widget </> a la izquierda de la
 * clase puedes ir a su declaración en el manifiesto
 *
 * Para que una actividad se pueda lanzar como actividad
 * inicial desde el launcher
 * se debe exportar en el manifiesto
 * y se debe declarar en el intent-filter
 *
 * Para crear una UI en Compose y mostrarla como contenido
 * de la actividad esta debe extender la clase ComponentActivity()
 *
 * https://developer.android.com/guide/components/activities/intro-activities
 */
// CTRL + Clic sobre MainActivity para ir a su declaración en el manifiesto
class MainActivity : ComponentActivity() {


    /**
     * Se llama al callback onCreate()
     * una vez la actividad ha sido adjuntada a la aplicación
     * y se ha creado su contexto
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Este método pertenece a la biblioteca base androidx.activity:activity
         * (introducido en las versiones recientes para reflejar la pantalla completa
         * detrás de las barras del sistema)
         */
        /**
         * Con enableEdgeToEdge la navigation bar se muestra con fondo transparente
         */
        //enableEdgeToEdge() // Comentar y descomentar para ver su efecto

        /**
         * El método setContent { ... } no pertenece a la biblioteca de Compose (androidx.compose.ui).
         * Es un método de extensión creado específicamente para la clase ComponentActivity,
         * y está alojado únicamente dentro de la biblioteca androidx.activity:activity-compose
         *
         * La lambda con la que llamanos a setContent es la trailing lambda
         * argumento para el parámetro content de tipo @Composable (() -> Unit)
         * Es decir, es un composable
         */
        setContent {
            PMDMComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PMDMComposeTheme {
        Greeting("Android")
    }
}