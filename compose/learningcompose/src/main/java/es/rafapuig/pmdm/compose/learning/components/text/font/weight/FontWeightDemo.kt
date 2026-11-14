package es.rafapuig.pmdm.compose.learning.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.components.text.font.aladin
import es.rafapuig.pmdm.compose.learning.components.text.font.indieFlower

@Composable
fun FontWeightDemo() {
    Text("Font weight Thin", fontWeight = FontWeight.Thin) // Alias de W100
    Text("Font weight ExtraLight", fontWeight = FontWeight.ExtraLight) // Alias de W200
    Text("Font weight Light", fontWeight = FontWeight.Light) // Alias de W300
    Text("Font weight Normal", fontWeight = FontWeight.Normal) // Alias de W400
    Text("Font weight Medium", fontWeight = FontWeight.Medium) // Alias de W500
    Text("Font weight SemiBold", fontWeight = FontWeight.SemiBold) // Alias de W600
    Text("Font weight Bold", fontWeight = FontWeight.Bold) // Alias de W700
    Text("Font weight ExtraBold", fontWeight = FontWeight.ExtraBold) // Alias de W800
    Text("Font weight Black", fontWeight = FontWeight.Black) // Alias de W900
}

@Composable
fun FontWeightDemo2() {
    Text("Font weight W100", fontWeight = FontWeight.W100) // Alias de Thin
    Text("Font weight W200", fontWeight = FontWeight.W200) // Alias de ExtraLight
    Text("Font weight W300", fontWeight = FontWeight.W300) // Alias de Light
    Text("Font weight W400", fontWeight = FontWeight.W400) // Alias de Normal
    Text("Font weight W500", fontWeight = FontWeight.W500) // Alias de Medium
    Text("Font weight W600", fontWeight = FontWeight.W600) // Alias de SemiBold
    Text("Font weight W700", fontWeight = FontWeight.W700) // Alias de Bold
    Text("Font weight W800", fontWeight = FontWeight.W800) // Alias de ExtraBold
    Text("Font weight W900", fontWeight = FontWeight.W900) // Alias de Black
}

@Preview(showBackground = true)
@Composable
fun FontWeightDemoPreview() {
    Column {
        FontWeightDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun FontWeightDemoPreview2() {
    Column {
        FontWeightDemo2()
    }
}

@Preview(showBackground = true)
@Composable
fun FontWeightDemoPreview3() {
    CompositionLocalProvider(
        LocalTextStyle provides
                LocalTextStyle.current.copy(fontFamily = indieFlower.fontFamily)
    ) {
        Column {
            FontWeightDemo()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FontWeightDemoPreview4() {
    CompositionLocalProvider(
        LocalTextStyle provides
                LocalTextStyle.current.copy(fontFamily = aladin.fontFamily)
    ) {
        Column {
            FontWeightDemo2()
        }
    }
}