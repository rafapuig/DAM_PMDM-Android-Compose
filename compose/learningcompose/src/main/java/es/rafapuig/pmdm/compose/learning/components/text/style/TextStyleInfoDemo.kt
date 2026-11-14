package es.rafapuig.pmdm.compose.learning.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.ui.theme.pastel.PastelTheme


@Composable
fun TextStyleInfo(
    style: TextStyle,
    modifier: Modifier = Modifier) {

    Column {
        //Text(style.toString())

        Text("Color: ${style.color}")
        Text("Brush: ${style.brush}")
        Text("Alpha: ${style.alpha}")
        Text("Background: ${style.background}")
        Text("Shadow: ${style.shadow}")
        Text("Draw style: ${style.drawStyle}")

        Text("Font size: ${style.fontSize}")
        Text("Font weight: ${style.fontWeight}")
        Text("Font style: ${style.fontStyle}")
        Text("Font synthesis: ${style.fontSynthesis}")
        Text("Font family: ${style.fontFamily}")
        Text("Font feature Settings: ${style.fontFeatureSettings}")

        Text("Letter spacing: ${style.letterSpacing}")
        Text("Baseline shift: ${style.baselineShift}")
        Text("Line height: ${style.lineHeight}")
        Text("Line height style: ${style.lineHeightStyle}")
        Text("Line break: ${style.lineBreak}")


        Text("Text align: ${style.textAlign}")
        Text("Text decoration: ${style.textDecoration}")
        Text("Text direction: ${style.textDirection}")
        Text("Text Geometric transform: ${style.textGeometricTransform}")
        Text("Text indent: ${style.textIndent}")
        Text("Text motion: ${style.textMotion}")

        Text("Hyphens: ${style.hyphens}")
        Text("Local list : ${style.localeList}")
        Text("Platform style: ${style.platformStyle}")
    }

}


@Preview(showBackground = true)
@Composable
fun TextStyleCurrentDemo(modifier: Modifier = Modifier) {

    val style : TextStyle = LocalTextStyle.current

    TextStyleInfo(style)
}

@Preview(showBackground = true)
@Composable
fun TextStyleDefaultDemo(modifier: Modifier = Modifier) {
    TextStyleInfo(TextStyle.Default)
}

@Preview(showBackground = true)
@Composable
fun TextStyleMaterialDemo(modifier: Modifier = Modifier) {
    MaterialTheme {
        TextStyleInfo(LocalTextStyle.current)
    }
}

@Preview(showBackground = true)
@Composable
fun TextStyleThemelDemo(modifier: Modifier = Modifier) {
    PastelTheme {
        TextStyleInfo(LocalTextStyle.current)
    }
}
