package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import es.rafapuig.pmdm.compose.exercises.R

data class CourseItemInfo(
    val title: String,
    val name: String,
    val price: Int,
    val score: Double,
    val picUrl: Int
)

val sampleCourses = listOf(
    CourseItemInfo(
        "Diseño de UI", name = "Sofia", price = 45, score = 4.5,
        picUrl = R.drawable.ratatouille
    ),
    CourseItemInfo(
        title = "Marketing Digital",
        name = "Juan",
        price = 50,
        score = 4.9,
        picUrl = R.drawable.ratatouille
    ),
    CourseItemInfo(
        title = "Programación Avanzada",
        name = "María",
        price = 60,
        score = 6.8,
        picUrl = R.drawable.ratatouille
    )
)