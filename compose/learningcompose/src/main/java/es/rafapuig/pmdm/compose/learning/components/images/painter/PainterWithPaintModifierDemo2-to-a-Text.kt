package es.rafapuig.pmdm.compose.learning.components.images.painter

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.compose.learning.R


@Composable
private fun PainterWithPaintModifierInTextDemo(
    modifier: Modifier = Modifier
) {
    val painter = painterResource(R.drawable.levante_ud_logo)

    Text(
        "Modificador painter",
        color = Color.Green,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier.paint(painter = painter)
            .wrapContentHeight() // Para que se centre verticalmente
    )
}


@Preview(showBackground = true)
@Composable
private fun PainterWithPaintModifierInTextDemoPreview() {
    PainterWithPaintModifierInTextDemo()
}