package es.rafapuig.pmdm.compose.learning.concepts.state.examples.person_developer.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import es.rafapuig.pmdm.compose.learning.concepts.state.examples.person_developer.model.Person
import es.rafapuig.pmdm.compose.learning.concepts.state.examples.person_developer.model.persons

/**
 * Una clase parameter provider de objetos de tipo Person
 * para inyectar un argumento de tipo persona
 * en una función composable con anotación @Preview
 * que declare un parámetro de tipo Person
 */
class PersonProvider : PreviewParameterProvider<Person> {
    override val values: Sequence<Person>
        get() = persons.asSequence()
}