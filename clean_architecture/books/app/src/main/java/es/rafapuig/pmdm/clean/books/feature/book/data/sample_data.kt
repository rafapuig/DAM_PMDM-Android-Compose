package es.rafapuig.pmdm.clean.books.feature.book.data

import es.rafapuig.pmdm.clean.books.feature.book.domain.model.Book

val dummyBooks = (1..20).map {
    Book(
        id = it.toString(),
        title = "Kotlin",
        authors = listOf("Rafael Puig"),
        averageRating = 4.55
    )
}

val sampleBooks = listOf(
    Book(
        id = "1",
        title = "Kotlin in action",
        authors = listOf("Sebastian Aigner", "Author 2"),
        averageRating = 2.257
    ),
    Book(
        id = "2",
        title = "Jetpack Compose 1.8 Essentials",
        authors = listOf("Neil Smyth", "Author 2"),
        averageRating = 3.89
    ),
    Book(
        id = "3",
        title = "Kotlin programming",
        authors = listOf("Rafael Puig", "Author 2"),
        averageRating = 4.555
    )
)