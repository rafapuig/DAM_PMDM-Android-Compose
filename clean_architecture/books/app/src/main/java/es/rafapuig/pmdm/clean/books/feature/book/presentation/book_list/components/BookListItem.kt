package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.clean.books.feature.book.domain.model.Book
import es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.preview.BooksPreview
import es.rafapuig.pmdm.clean.books.ui.theme.BooksTheme
import es.rafapuig.pmdm.clean.books.ui.theme.LightBlue

@Composable
fun BookListItem(
    book: Book,
    modifier: Modifier = Modifier,
    onClick: (Book) -> Unit = {},
) {
    Card(
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (!isSystemInDarkTheme()) LightBlue.copy(alpha = 0.2f)
                else MaterialTheme.colorScheme.surface
        ),
        modifier = modifier.clickable { onClick(book) }

    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            BookCoverImage(book)

            BookInfo(
                book,
                modifier = Modifier
                    .fillMaxHeight() // Dado que hemos limitado el Row con el IntrisicSize
                    .weight(1f) // Ocupará todo el espacio restante disponible en la Row
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookListItemPreview(
    @PreviewParameter(BooksPreview::class) book: Book
) {
    BooksTheme(darkTheme = true) {
        BookListItem(book = book)
    }
}