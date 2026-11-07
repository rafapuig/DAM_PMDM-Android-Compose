package es.rafapuig.pmdm.compose.learning.concepts.state

import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyStatefulSlider(modifier: Modifier = Modifier) {

    var sliderPosition by remember { mutableFloatStateOf(30f) }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 20f..40f,
        steps = 5
    )

}


/**
 * Este composable no tiene estado -> stateless
 * (no declara ninguna variable que delegue en un objeto State)
 */
@Composable
fun MyStatelessSlider(
    sliderPosition: Float,
    onPositionChange: (Float) -> Unit = {}
) {
    Slider(
        value = sliderPosition,
        onValueChange = onPositionChange,
        valueRange = 20f..40f,
        steps = 10
    )
}

@Preview
@Composable
fun MyStatelessSliderPreview() {
    var sliderPosition by remember { mutableFloatStateOf(30f) }
    MyStatelessSlider(
        sliderPosition = sliderPosition,
        onPositionChange = { sliderPosition = it }
    )
}