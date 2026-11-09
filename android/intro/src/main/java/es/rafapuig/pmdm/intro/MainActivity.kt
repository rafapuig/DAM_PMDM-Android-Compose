package es.rafapuig.pmdm.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.intro.ui.theme.PMDMComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Este método pertenece a la biblioteca base androidx.activity:activity
         * (introducido en las versiones recientes para reflejar la pantalla completa
         * detrás de las barras del sistema)
         */
        /**
         * Sin Edge-to-Edge:
         * Las barras del sistema se mezclan su color con el color de la pantalla.
         *
         * Con Edge-to-Edge:
         * Las barras del sistema son capas transparentes que flotan sobre tu app
         */
        enableEdgeToEdge()

        /**
         * Se llama a setContent() para establecer el contenido de la actividad.
         * Llamamos a la función del tema personalizado
         * PMDMComposeTheme() en este caso
         * y llamamos a la función MainScreen()
         * que se encargará de componer la pantalla de la UI
         */
        setContent {
            PMDMComposeTheme {
                MainScreenWithBox()
            }
        }
    }
}