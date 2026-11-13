package es.rafapuig.pmdm.previewsdemo.people.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.previewsdemo.people.model.Person
import es.rafapuig.pmdm.previewsdemo.people.model.persons



/**
 * Función composable (composable, component)
 * función especial que se usa para crear interfaces de usuario (UI) mediante Compose
 * Cuando se llama a un composable
 * se le pasan datos (una persona en este caso)
 * y un conjunto de propiedades que definen su apariencia (tamaño de la fuente)
 * y comportamiento
 *
 * En esencia, un composable transforma datos en elementos de UI
 *
 * Una función composable no devuelve un valor,
 * emite elementos de UI al sistema de composición para su renderizado.
 *
 * Una función composable puede llamar a otra función composable
 * para crear una jerarquía de composables.
 */
@Composable // las funciones composables llevan la anotación @Composable
fun PersonItem(
    person: Person, // // Recibe como dato una persona a presentar en la UI
    modifier: Modifier = Modifier, // Un composable debe tener un parámetro Modifier
    fontSize: Int = 32 // El resto de parámetros opcionales va después del modifier
) {
    // Llamada a la función composable Column integrada (built-in)
    Column(modifier = modifier.padding(16.dp)) {
        Text("Name: ${person.name}", fontSize = fontSize.sp)
        Text("Age: ${person.age}", fontSize = fontSize.sp)
    }
}


/**
 * PersonsProvider es un proveedor de parámetros para la vista de previsualización.
 * Por ello, implementa la interface PreviewParameterProvider<Person>
 * implementando el getter de values que devuelve una secuencia de Person.
 */
class PersonsProvider : PreviewParameterProvider<Person> {
    override val values: Sequence<Person>
        get() = persons.asSequence()  //sequenceOf(*persons.toTypedArray()) //sequence { yieldAll(persons) }
}

/**
 * Una función anotada con @Preview
 * no puede declarar parámetros de entrada
 * a menos que tengan un valor predeterminado
 * o estén anotados con @PreviewParameter
 */
@Preview(showBackground = true)
@Composable
fun PersonItemPreview(
    // Anotamos con @PreviewParameter el parámetro person para que sea proveído
    @PreviewParameter(PersonsProvider::class)
    person: Person
) {
    /**
     * Llamamos a la función composable que queremos previsualizar
     * Se creará una preview por cada elemento proporcionado por el proveedor
     */
    PersonItem(person, modifier = Modifier.fillMaxWidth())
}