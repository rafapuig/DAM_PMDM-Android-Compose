package es.rafapuig.pmdm.compose.learning.layout.layouts.box

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * El layout Box proporciona modificadores adicionales
 * para aplicar a los composables hijos
 * son los BoxScope modifiers
 * - align()
 * - matchParentSize()
 */

@Preview(showBackground = true, widthDp = 500, heightDp = 500)
@Composable
private fun BoxLayoutWithMatchParentSizePreview() {
    Box(modifier = Modifier.background(Color.DarkGray)) {
        /**
         * Como el Box parent no tiene tamaño, el tamaño lo fijan los hijos
         * y como un hijo usa matchParentSize se usa el tamaño resultante de las necesidades
         * de los hijos
         */
        BoxLayoutWithMatchParentSize()
    }
}

@Preview(showBackground = true, widthDp = 500, heightDp = 500)
@Composable
private fun BoxLayoutWithFillMaxSizePreview() {
    /**
     * Como el Box parent no tiene tamaño, el tamaño lo fijan los hijos
     * y como un hijo usa fillMaxSize se usa el tamaño del contenedor del padre 500x500
     */
    Box(modifier = Modifier.background(Color.DarkGray)) {
        BoxLayoutWithFillMaxSize()
    }
}

@Preview(showBackground = true, widthDp = 500, heightDp = 500)
@Composable
private fun BoxLayoutWithMatchParentSizeWithParentBoxSize450Preview() {
    Box(modifier = Modifier.background(Color.DarkGray)) {
        /**
         * Si le damos un tamaño de 475 al Box padre
         * entonces los composables hijos no determinan el tamaño porque son más
         * pequeños y matchParentSize viene determinado por el tamaño del Box padre
         */
        BoxLayoutWithMatchParentSize(Modifier.size(450.dp))
    }
}

@Preview(showBackground = true, widthDp = 500, heightDp = 500)
@Composable
private fun BoxLayoutWithMatchParentSizeWithParentBoxSize300Preview() {
    Box(modifier = Modifier.background(Color.DarkGray)) {
        /**
         * Si le damos un tamaño de 300 al Box padre
         * entonces los composables hijos tampoco determinan el tamaño y al ser más
         * pequeños su tamaño se reduce para caber
         * matchParentSize viene determinado una vez más por el tamaño del Box padre
         */
        BoxLayoutWithMatchParentSize(Modifier.size(300.dp))
    }
}

@Preview(showBackground = true, widthDp = 500, heightDp = 500)
@Composable
private fun BoxLayoutWithFillMaxSizeWithParentBoxSizePreview() {
    Box(modifier = Modifier.background(Color.DarkGray)) {
        /**
         * Si le damos un tamaño de 450 al Box padre
         * Entonces da igual si usamos fillMaxSize para el último TextCell
         * o usamos matchParentSize
         */
        BoxLayoutWithFillMaxSize(Modifier.size(450.dp))
    }
}

@Composable
private fun BoxLayoutWithMatchParentSize(modifier: Modifier = Modifier) {
    /**
     * Cuando el Box no tenga tamaño definido por el modifier
     * su tamaño se calculará a partir del tamaño de sus hijos
     */

    Box(
        modifier = modifier
            //.size(300.dp)
            .background(Color.White)
    ) {
        /**
         * Este TextCell podrá determinar el ancho del Box padre al ser el de mayor ancho
         */
        TextCell(
            "Cell 400 x 300 cyan",
            modifier = Modifier
                .width(400.dp)
                .height(300.dp)
                .background(Color.Cyan)
        )

        /**
         * Este TexCell hijo podrá determinar el alto del Box padre al ser el más alto
         */
        TextCell(
            "Cell 100 x 400",
            Modifier
                .width(100.dp)
                .height(400.dp)
                .align(Alignment.BottomEnd)
                .background(Color.Yellow)
        )

        /**
         * Este TexCell hijo no influye porque su ancho y alto son menores a los de otros composables
         * hijos del Box Padre
         */
        TextCell(
            "Cell size 100 dp",
            Modifier
                .size(100.dp)
                .align(Alignment.BottomStart)
        )

        /**
         * Este TextCell acaba teniendo las medidas resultantes del Box padre
         * calculadas a partir de los hijos (si al Box padre no se ha fijado tamaño)
         * y no influye en el cálculo de estas medidas
         */
        TextCell(
            "Cell match parent size",
            Modifier
                .matchParentSize()
                .background(
                    brush = Brush.radialGradient(listOf(Color.White, Color.Magenta)),
                    alpha = 0.4f
                )
        )
    }
}

@Composable
private fun BoxLayoutWithFillMaxSize(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            //.size(300.dp)
            .background(Color.White)
    ) {

        TextCell(
            "Cell 400 x 300 cyan",
            modifier = Modifier
                .width(400.dp)
                .height(300.dp)
                .background(Color.Cyan)
        )

        TextCell(
            "Cell 100 x 400",
            Modifier
                .width(100.dp)
                .height(400.dp)
                .align(Alignment.BottomEnd)
                .background(Color.Yellow)
        )

        TextCell(
            "Cell size 100 dp",
            Modifier
                .size(100.dp)
                .align(Alignment.BottomStart)
        )

        /**
         * Este TextCell ahora con fillMaxSize es el que acaba fijando el tamaño del Box padre
         * cuando el Box padre no tiene tamaño,
         * y entonces fillMaxSize hace que el tamaño sea el del contenedor del padre
         * (si este ha sido fijado, o del padre del padre ...)
         */
        TextCell(
            "Cell match parent size",
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(listOf(Color.White, Color.Magenta)),
                    alpha = 0.4f
                )
        )
    }
}

@Composable
private fun TextCell(
    text: String,
    modifier: Modifier = Modifier,
    fontColor: Color = Color.Blue,
    fontSize: Int = 14
) {
    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 1.dp, color = Color.Black)
        .then(modifier)
        .wrapContentHeight(align = Alignment.CenterVertically)

    //Surface {
    Text(
        text = text,
        modifier = cellModifier,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = fontColor
    )
    //}
}