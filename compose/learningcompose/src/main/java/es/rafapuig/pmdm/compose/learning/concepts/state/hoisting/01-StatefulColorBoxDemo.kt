package es.rafapuig.pmdm.compose.learning.concepts.state.hoisting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    /**
     * Estado "color" declarado por el composable ColorBox
     * lo que lo convierte en un stateful composable
     */
    var color by remember {
        mutableStateOf(Color.Yellow)
    }

    Box(
        modifier = modifier
            .background(color)
            .size(300.dp)
            .clickable { color = Color.random() })
}


@Preview
@Composable
private fun ColorBoxPreview() {
    ColorBox()
}