package es.rafapuig.pmdm.compose.learning.components.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.compose.learning.R
import es.rafapuig.pmdm.compose.learning.ui.theme.pastel.PastelTheme

@Preview(showBackground = true, widthDp = 190)
@Composable
fun TextDemo() {

    val captionModifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF76BEFF))

    val defaultStyle = TextStyle.Default
    val materialStyle = MaterialTheme.typography.bodyLarge

    // Parece que si estamos bajo la llamada al tema es el bodyLarge de material
    // Si no, valores inespecíficos
    val currentStyle = LocalTextStyle.current
        //.merge(MaterialTheme.typography.bodyLarge)

    Column {

        /**
         * Uso básico de Text
         * (utiliza como estilo el LocalTextStyle.current)
         */
        Text("Hola Compose!!")
        Text("Current Text Style", fontWeight = FontWeight.Bold, modifier = captionModifier)
        Text("Font family: ${currentStyle.fontFamily}")
        Text("Font weight: ${currentStyle.fontWeight?.weight}")
        Text("Font size: ${currentStyle.fontSize.value}")
        Text("Line height: ${currentStyle.lineHeight}")



        HorizontalDivider()

        /**
         * Cambio del color en el estilo
         */
        Text("Color Red!!", color = Color.Red)
        Text("Color Blue!!", color = Color(0xFF0000FF))
        Text("Color from theme primary", color = MaterialTheme.colorScheme.primary)
        Text("Color from theme secondary", color = MaterialTheme.colorScheme.secondary)
        Text("Color from theme tertiary", color = MaterialTheme.colorScheme.tertiary)

        HorizontalDivider()

        /**
         * Cambio en el tamaño de la fuente
         * Para el texto se utilizan scale-independent units SP
         *
         * sp es una unidad que:
         * ✔ Se adapta a la densidad de pantalla
         * ✔ Se adapta al tamaño de fuente configurado por el usuario
         * ✔ Respeta accesibilidad
         *
         * Es decir, si el usuario aumenta el tamaño del texto en el sistema:
         * Ajustes → Tamaño de fuente
         * Los valores en sp crecerán automáticamente.
         */
        Text("Font size 12 sp", fontSize = 12.sp)
        Text("Font size 18 sp", fontSize = 18.sp)
        Text("Font size 24 sp", fontSize = 24.sp)

        Text("Font size ${defaultStyle.fontSize.value} sp", fontSize = defaultStyle.fontSize)

        Text("Font size ${materialStyle.fontSize.value} sp", fontSize = materialStyle.fontSize)

        val defaultFontSize = LocalTextStyle.current
            .merge(MaterialTheme.typography.bodyLarge).fontSize.value
        Text("Font size $defaultFontSize sp", fontSize = LocalTextStyle.current.fontSize)
        Text("Font size $defaultFontSize sp", fontSize = defaultFontSize.sp)

        HorizontalDivider()

        Text("Font weight ExtraLight", fontWeight = FontWeight.Thin) // Alias de W100
        Text("Font weight ExtraLight", fontWeight = FontWeight.ExtraLight) // Alias de W200
        Text("Font weight Light", fontWeight = FontWeight.Light) // Alias de W300
        Text("Font weight Normal", fontWeight = FontWeight.Normal) // Alias de W400
        Text("Font weight Medium", fontWeight = FontWeight.Medium) // Alias de W500
        Text("Font weight SemiBold", fontWeight = FontWeight.SemiBold) // Alias de W600
        Text("Font weight Bold", fontWeight = FontWeight.Bold) // Alias de W700
        Text("Font weight ExtraBold", fontWeight = FontWeight.ExtraBold) // Alias de W800
        Text("Font weight Black", fontWeight = FontWeight.Black) // Alias de W900

        HorizontalDivider()

        Text("Font style Normal", fontStyle = FontStyle.Normal)
        Text("Font style Italic", fontStyle = FontStyle.Italic)

        HorizontalDivider()

        Text("Fuente Indie Flower", fontFamily = FontFamily(Font(R.font.indie_flower)))

        HorizontalDivider()

        Text("Letter spacing 8", letterSpacing = 8.sp)
        Text("Letter spacing 4", letterSpacing = 4.sp)

        HorizontalDivider()
        Text("Text Decoration Underline", textDecoration = TextDecoration.Underline)
        Text("Text Decoration LineThrough", textDecoration = TextDecoration.LineThrough)
        Text(
            "Text Decoration Both",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )

        HorizontalDivider()

        Text("Align center", textAlign = TextAlign.Center, modifier = Modifier.width(190.dp))
        Text("Align End", textAlign = TextAlign.End, modifier = Modifier.width(190.dp))
        Text(
            "Align Justify (texto para rellenar lineas)",
            textAlign = TextAlign.Justify,
            modifier = Modifier.width(190.dp)
        )

        HorizontalDivider()

        Text("Line height ${materialStyle.lineHeight} sp")
        Text("Line height 30 sp", lineHeight = 30.sp)
        Text("Line height 40 sp", lineHeight = 40.sp)

        HorizontalDivider()

        Text(
            "Overflow Ellipsis (texto para rellenar)",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.width(190.dp)
        )
        Text(
            "Middle Ellipsis (texto para rellenar)",
            overflow = TextOverflow.MiddleEllipsis,
            maxLines = 1,
            modifier = Modifier.width(190.dp)
        )

        Text(
            "Como si hubiera espacio horizontal ilimitado",
            softWrap = false,
            modifier = Modifier.width(190.dp)
        )
        Text(
            "SoftWrap salta de linea cuando se acaba el espacio",
            softWrap = true,
            modifier = Modifier.width(190.dp)
        )

        Text(
            text = "Hola Compose!!!",
            style = LocalTextStyle.current.copy(
                color = Color.Red
            )
        )

        /**
         * Aplicamos Composición Local
         * con el TextStyle guardado en el estado LocalTextStyle
         */
        ProvideTextStyle(TextStyle(color = Color.Green)) {
            Text("Hola Compose local styled!!!")

            ProvideTextStyle(TextStyle(fontStyle = FontStyle.Italic)) {
                Text("Adios Compose local styled!!!")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 190, heightDp = 1000)
@Composable
fun TextDemoPreview() {
    PastelTheme {
        TextDemo()
    }
}
