package es.rafapuig.pmdm.compose.learning.components.text.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import es.rafapuig.pmdm.compose.learning.R

data class FontInfo(
    val name: String,
    val fontFamily: FontFamily
)

private fun Pair<String, Int>.toFontInfo() =
    FontInfo(
        name = first,
        fontFamily = FontFamily(Font(second))
    )

val indieFlower = ("indie flower" to R.font.indie_flower).toFontInfo()
val aclonica = ("aclonica" to R.font.aclonica).toFontInfo()
val aladin = ("aladin" to R.font.aclonica).toFontInfo()
val nunito = ("nunito" to R.font.nunito).toFontInfo()
val aldrich = ("aldrich" to R.font.aldrich).toFontInfo()
val aquafinaScript = ("aquafina script" to R.font.aguafina_script).toFontInfo()


val appFonts = mapOf(
    "indie flower" to R.font.indie_flower,
    "aclonica" to R.font.aclonica,
    "aladin" to R.font.aladin,
    "nunito" to R.font.nunito,
    "aldrich" to R.font.aldrich,
    "aquafina script" to R.font.aguafina_script
).map {
    FontInfo(it.key, FontFamily(Font(it.value)))
}