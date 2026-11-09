package es.rafapuig.pmdm.insets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.insets.ui.theme.PMDMComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val windowInsets = WindowInsets.systemBars.add(
                WindowInsets(top = (-24).dp, left = 16.dp, right = 16.dp, bottom = (-24).dp)
            )

            PMDMComposeTheme {
                /**
                 * Si no se llama a enableEdgeToEdge
                 * el color de fondo del contenedor se mezcla con el color de la navigation bar (abajo)
                 */
                /**
                 * La propiedad systemBars solamente la podemos usar dentro de un composable
                 * (por eso aparece en color verde claro)
                 */

                //Scaffold(
                //    containerColor = Color.Cyan,
                //contentWindowInsets = windowInsets
                //) { innerPadding ->
                /**
                 * Ponemos este Box como composable hijo del Scaffold
                 * y, por tanto, recibe los insets en forma de PaddingValues
                 * y los debemos aplicar por ser este el composable hijo
                 */
                Box(
                    modifier = Modifier
                        //.padding(padding)
                        .windowInsetsPadding(windowInsets)
                        .background(Color.Blue.copy(alpha = 0.7f))
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Greeting(
                        name = "Android",
                        modifier = Modifier
                            .background(Color.Yellow)
                    )
                }
            }

            //}
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