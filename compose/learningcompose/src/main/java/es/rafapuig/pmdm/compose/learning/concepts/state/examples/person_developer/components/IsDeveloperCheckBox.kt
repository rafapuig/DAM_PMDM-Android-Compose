package es.rafapuig.pmdm.compose.learning.concepts.state.examples.person_developer.components

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable

@Composable
fun IsDeveloperCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = { onCheckedChange(it) }
    )
}