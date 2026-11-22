package es.rafapuig.pmdm.compose.learning.architecture

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.compose.learning.TAG
import es.rafapuig.pmdm.compose.learning.layout.modifiers.ModifiersDemoScreenPreview
import es.rafapuig.pmdm.compose.learning.ui.theme.PMDMComposeTheme

@Composable
fun LifeCycleDemo() {

    // Estado observable de Compose
    var counter by remember { mutableIntStateOf(0) }

    Button(onClick = {
        Log.d(TAG, "Incrementando el contador ...")
        counter++
        Log.d(TAG, "Ahora su valor es $counter")
    }) {
        Text("Pulsarme", fontSize = 24.sp)
    }

    val annotatedText = buildAnnotatedString {
        append("Has pulsado el botón ")
        withStyle(
            SpanStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("$counter")
        }
        append(" veces")
    }

    // La lectura del estado counter hace que se llame
    // a la función LifeCycleDemo de nuevo para la recomposición
    // (prueba a comentar la línea de abajo y que Text no entre en la composición)
    //Text("Has pulsado el botón $counter veces")
    Text(annotatedText)

    SideEffect {
        Log.d(TAG, "Recomposición de LifeCycleDemo, counter = $counter")
    }
}


@Preview
@Composable
fun LifeCycleDemoPreview() {
    PMDMComposeTheme(darkTheme = true) {
        Surface {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
            ) {
                LifeCycleDemo()
            }
        }
    }
}