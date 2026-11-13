package es.rafapuig.pmdm.compose.learning.layout.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * https://developer.android.com/develop/ui/compose/layouts/constraints-modifiers#sizein-modifier
 */

@Composable
private fun MyBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .border(1.dp, Color.LightGray)
                then modifier
                then Modifier.background(Color.Red)
    )
}


@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxSizeInPreview() {
    Box {
        MyBox(
            modifier = Modifier
                // Establecer un nuevo conjunto de restricciones
                // Si las del padre son más estrictas todavía entonces ganan
                .sizeIn(150.dp, 100.dp, 200.dp, 150.dp)
                .fillMaxSize() // Se aplican las restricciones de máximos en alto y ancho
                .requiredSize(50.dp) // tamaño con el que se dibujará
        )
    }
}

@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxSizeInMinConstraintsPreview() {
    Box {
        MyBox(
            modifier = Modifier
                // Establecer un nuevo conjunto de restricciones
                // Si las del padre son más estrictas todavía entonces ganan
                .sizeIn(150.dp, 100.dp, 200.dp, 150.dp)
                .requiredSize(50.dp) // tamaño con el que se dibujará
        )
    }
}

@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxSizeInMaxWidthConstraintPreview() {
    Box {
        MyBox(
            modifier = Modifier
                // Establecer un nuevo conjunto de restricciones
                // Si las del padre son más estrictas todavía entonces ganan
                .sizeIn(150.dp, 100.dp, 200.dp, 150.dp)
                .fillMaxWidth() // Se aplica la restricción maxima de ancho (no de alto - la min)
                .requiredSize(50.dp) // tamaño con el que se dibujará
        )
    }
}

@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxSizeInMaxHeightConstraintPreview() {
    Box {
        MyBox(
            modifier = Modifier
                // Establecer un nuevo conjunto de restricciones
                // Si las del padre son más estrictas todavía entonces ganan
                .sizeIn(150.dp, 100.dp, 200.dp, 150.dp)
                .fillMaxHeight() // Se aplica la restricción maxima de alto
                .requiredSize(50.dp) // tamaño con el que se dibujará
        )
    }
}