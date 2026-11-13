package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.clean.books.R
import es.rafapuig.pmdm.clean.books.feature.book.data.sampleBooks
import es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.BookListAction
import es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.BookListState
import es.rafapuig.pmdm.clean.books.ui.theme.BooksTheme

@Composable
fun FavoritesPageContent(
    state: BookListState,
    onAction: (BookListAction) -> Unit
) {
    if (state.favoriteBooks.isEmpty()) {
        MessageText(stringResource(R.string.no_favorites))
    } else {
        BookList(
            books = state.favoriteBooks,
            onBookClick = {
                onAction(BookListAction.OnBookClick(it))
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FavoritesPageContentPreview() {
    BooksTheme(darkTheme = true) {
        FavoritesPageContent(
            state = BookListState(favoriteBooks = sampleBooks)
        ) { }
    }
}