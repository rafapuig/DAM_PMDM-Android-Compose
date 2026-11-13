package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.clean.books.feature.book.domain.model.Book
import es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.preview.BooksPreview
import es.rafapuig.pmdm.clean.books.ui.theme.BooksTheme
import kotlin.math.round
import kotlin.math.roundToInt

@Composable
fun BookInfo(
    book: Book,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically)
    ) {
        // Titulo
        Text(
            text = book.title,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        // Autores
        book.authors.firstOrNull()?.let { authorName ->
            Text(
                text = authorName,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        book.averageRating?.let { rating ->

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${round(rating * 10) / 10.0}",
                    style = MaterialTheme.typography.bodyMedium
                )
                for (i in 1..rating.roundToInt())
                    StarIcon()
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun BookInfoPreview(
    @PreviewParameter(BooksPreview::class) book : Book
) {
    BooksTheme(darkTheme = true) {
        BookInfo(
            book,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}