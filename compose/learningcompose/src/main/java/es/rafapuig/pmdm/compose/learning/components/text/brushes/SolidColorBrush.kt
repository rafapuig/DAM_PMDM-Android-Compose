package es.rafapuig.pmdm.compose.learning.components.text.brushes

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.ui.theme.PMDMComposeTheme

@Preview(showBackground = true)
@Composable
fun SolidColorBrushDemo1(modifier: Modifier = Modifier) {

    val color = Color(0xFF3949AB)
    val solidColorBrush = SolidColor(color)

    /**
     * Cuidado, cuando pasamos estilo, machacamos el que viene del contexto
     * mediante LocalTextSytle.current
     */

    PMDMComposeTheme {
        Text(
            text = "Solid Brush",
            style = LocalTextStyle.current.copy(
                brush = SolidColor(Color(0xFF3949AB))
            )
        )
    }

}


@Preview(showBackground = true)
@Composable
fun SolidColorBrushDemo2(modifier: Modifier = Modifier) {

    val color = Color(0xFF8E24AA)
    val solidColorBrush = SolidColor(color)

    val textStyle = LocalTextStyle.current
        .copy(brush = solidColorBrush)

    Text(text = "Solid Brush", style = textStyle)
}


@Preview(showBackground = true)
@Composable
fun SolidColorBrushDemo3(modifier: Modifier = Modifier) {

    val color = Color(0xFFAD1457)
    val solidColorBrush = SolidColor(color)

    PMDMComposeTheme {

        /**
         * También podemos hacer un merge de estilos
         * Si una característica del estilo se combina, prevalece el valor del segundo
         * estilo
         */

        // Para que LocalTextStyle.current tenga en cuenta los estilos del tema
        // debe llamarse dentro del content de la función XXXTheme
        val textStyle = LocalTextStyle.current
            .merge(
                TextStyle(
                    brush = solidColorBrush
                )
            )

        Text(text = "Solid Brush", style = textStyle)
    }
}