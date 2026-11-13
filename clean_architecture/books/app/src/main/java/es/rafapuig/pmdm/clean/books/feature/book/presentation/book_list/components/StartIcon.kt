package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.clean.books.ui.theme.BooksTheme
import es.rafapuig.pmdm.clean.books.ui.theme.SandYellow

@Composable
fun StarIcon(modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier,
        imageVector = Icons.Default.Star,
        contentDescription = null,
        tint = SandYellow
    )
}

@Preview
@Composable
private fun StartIconPreview() {
    BooksTheme {
        StarIcon()
    }
}