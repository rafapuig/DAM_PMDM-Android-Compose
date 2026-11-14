package es.rafapuig.pmdm.compose.learning.components.text.font.weight

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.components.text.font.nunito

fun FontWeight.Companion.aliasValues() = listOf(
    FontWeight.Thin,
    FontWeight.ExtraLight,
    FontWeight.Light,
    FontWeight.Normal,
    FontWeight.Medium,
    FontWeight.SemiBold,
    FontWeight.Bold,
    FontWeight.ExtraBold,
    FontWeight.Black
)

@Composable
fun FontWeightDemo(weight: FontWeight) {
    Text("$weight", fontWeight = weight) // Alias de W100

}

@Preview(showBackground = true)
@Composable
fun FontWeightDemoPreview() {
    Column {
        FontWeight.Companion.aliasValues().forEach {
            FontWeightDemo(it)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun FontWeightDemoPreview3() {
    CompositionLocalProvider(
        LocalTextStyle provides
                LocalTextStyle.current.copy(fontFamily = nunito.fontFamily)
    ) {
        Column {
            FontWeight.aliasValues().forEach {
                FontWeightDemo(it)
            }
        }
    }
}
