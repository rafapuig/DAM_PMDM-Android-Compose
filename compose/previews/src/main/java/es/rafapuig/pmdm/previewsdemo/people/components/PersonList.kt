package es.rafapuig.pmdm.previewsdemo.people.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.previewsdemo.people.model.Person
import es.rafapuig.pmdm.previewsdemo.people.model.persons
import kotlin.collections.forEach

/**
 * Función composable PersonList
 *
 * Recibe como dato una lista de personas
 *
 * Como la función tiene parámetros de entrada
 * no se le puede aplicar la anotación @Preview
 * Se usa una función wrapper que llama a esta función
 */
@Composable
fun PersonsListSimple(persons: List<Person>) {
    /**
     * Desde una función composable se puede llamar a otra función composable
     * personalizada (custom-built), en este caso a PersonItem
     */
    Column {
        persons.forEach { person ->
            PersonItem(person, fontSize = 24)
        }
    }
}

@Composable
fun PersonsList(
    persons: List<Person>,
    showDivider: Boolean = true
) {
    Column(modifier = Modifier.padding(16.dp)) {
        persons.forEachIndexed { index, person ->
            PersonItem(person, fontSize = 24)
            if (showDivider && index < persons.lastIndex) HorizontalDivider()
        }
    }
}

@Composable
fun PersonsLazyList(
    persons: List<Person>,
    showDivider: Boolean = true
) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        itemsIndexed(persons) { index, person ->
            PersonItem(person, fontSize = 24)
            if (showDivider && index < persons.lastIndex) HorizontalDivider()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PersonsListSimplePreview() {
    PersonsListSimple(persons)
}

/**
 * Función wrapper que llama a PersonsList
 * normalmente la llamaremos igual que la función composable que queremos previsualizar,
 * pero añadiéndole el sufijo Preview
 * La función llama a PersonsList con un argumento (lista de personas)
 * proporcionado en la llamada
 */
@Preview(showBackground = true)
@Composable
fun PersonsListPreview() {
    PersonsList(persons)
}

@Preview(showBackground = true)
@Composable
fun PersonsLazyListPreview() {
    PersonsLazyList(persons)
}