package es.rafapuig.pmdm.compose.learning.concepts.state.examples.person_developer.model

/**
 * El modelo de datos de una persona en la UI
 */
data class Person(
    val name: String,
    val age: Int,
    val isDeveloper: Boolean = false
)

val persons = listOf(
    Person("Perico Palotes", 45),
    Person("Pedro Gado", 25, isDeveloper = true),
    Person("Aitor Tilla", 18, isDeveloper = true)
)