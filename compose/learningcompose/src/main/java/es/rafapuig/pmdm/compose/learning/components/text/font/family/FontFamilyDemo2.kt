package es.rafapuig.pmdm.compose.learning.components.text.font.family

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import es.rafapuig.pmdm.compose.learning.components.text.font.FontInfo
import es.rafapuig.pmdm.compose.learning.components.text.font.appFonts

@Composable
fun FontFamilyDemo(
    fontInfo: FontInfo
) {
    Text(
        text = "Hola Compose!! (${fontInfo.name})",
        fontFamily = fontInfo.fontFamily
    )
}


class FontFamilyProvider
    : PreviewParameterProvider<FontInfo> {
    override val values
        get() = appFonts.asSequence()
}


@Preview(showBackground = true)
@Composable
fun FontFamilyDemoPreview(
    @PreviewParameter(FontFamilyProvider::class)
    fontInfo: FontInfo
) {
    MaterialTheme {
        FontFamilyDemo(fontInfo)
    }
}