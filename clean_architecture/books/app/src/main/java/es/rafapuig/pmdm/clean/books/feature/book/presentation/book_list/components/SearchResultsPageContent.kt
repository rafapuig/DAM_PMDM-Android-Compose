package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.clean.books.R
import es.rafapuig.pmdm.clean.books.core.presentation.UIText
import es.rafapuig.pmdm.clean.books.feature.book.data.sampleBooks
import es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.BookListAction
import es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.BookListState
import es.rafapuig.pmdm.clean.books.ui.theme.BooksTheme

@Composable
fun SearchResultsPageContent(
    state: BookListState,
    onAction: (BookListAction) -> Unit
) {
    if (state.isLoading) {
        CircularProgressIndicator()
    } else {
        when {
            state.errorMessage != null -> {
                MessageText(
                    state.errorMessage.asString(),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            state.searchResults.isEmpty() -> {
                MessageText(
                    stringResource(R.string.no_search_results),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            else -> {
                BookList(
                    books = state.searchResults,
                    onBookClick = {
                        onAction(BookListAction.OnBookClick(it))
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchResultsPageContentWhenIsLoadingPreview() {
    BooksTheme {
        SearchResultsPageContent(
            state = BookListState(isLoading = true)
        ) { }
    }
}

@Preview
@Composable
private fun SearchResultsPageContentWhenEmptyResultsPreview() {
    BooksTheme {
        SearchResultsPageContent(
            state = BookListState(isLoading = false, searchResults = emptyList())
        ) { }
    }
}

@Preview
@Composable
private fun SearchResultsPageContentWhenErrorPreview() {
    BooksTheme {
        SearchResultsPageContent(
            state = BookListState(
                isLoading = false,
                errorMessage = UIText.DynamicString("Se ha producido un error desconocido")
            )
        ) { }
    }
}

@Preview
@Composable
private fun SearchResultsPageContentWhenResultsPreview() {
    BooksTheme {
        SearchResultsPageContent(
            state = BookListState(isLoading = false, searchResults = sampleBooks)
        ) { }
    }
}