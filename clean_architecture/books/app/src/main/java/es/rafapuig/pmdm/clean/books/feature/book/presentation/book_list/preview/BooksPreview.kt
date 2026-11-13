package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.preview

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import es.rafapuig.pmdm.clean.books.feature.book.data.sampleBooks
import es.rafapuig.pmdm.clean.books.feature.book.domain.model.Book

class BooksPreview : CollectionPreviewParameterProvider<Book>(sampleBooks)