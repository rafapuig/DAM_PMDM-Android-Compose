package es.rafapuig.pmdm.compose.learning.components.menus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.compose.learning.data.Cities
import es.rafapuig.pmdm.compose.learning.data.City
import es.rafapuig.pmdm.compose.learning.data.SampleData
import es.rafapuig.pmdm.compose.learning.ui.theme.PMDMComposeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> Spinner(
    items: List<T>,
    modifier: Modifier = Modifier,
    label: String = "Selecciona una opción",
    itemToLabel: (T) -> String = { it.toString() },
    initialSelectedIndex: Int = -1,
    onItemSelected: (T) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableIntStateOf(initialSelectedIndex) }

    if (selectedIndex in items.indices) {
        onItemSelected(items[selectedIndex])
    }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        val text =
            if (selectedIndex in items.indices)
                itemToLabel(items[selectedIndex])
            else ""

        OutlinedTextField(
            value = text,
            onValueChange = { },
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor(
                    type = ExposedDropdownMenuAnchorType.PrimaryNotEditable,
                    enabled = true
                ) // 👈 Importante para posicionar el menú
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text(itemToLabel(item)) },
                    onClick = {
                        selectedIndex = index
                        expanded = false
                        onItemSelected(item)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun SpinnerM3ExamplePreview() {

    var selectedCity by remember { mutableStateOf<City?>(null) }

    PMDMComposeTheme(darkTheme = true) {
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Spinner(
                    items = SampleData.Cities.sortedBy { city -> city.name },
                    label = "Selecciona una ciudad",
                    itemToLabel = { it.name },
                    onItemSelected = { city -> selectedCity = city }
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = selectedCity?.name ?: "No se ha seleccionado ninguna ciudad",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterHorizontally)
                        .wrapContentSize()
                )
            }
        }
    }
}

