package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.clean.books.ui.theme.BooksTheme

@Composable
fun MessageText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.error,
    )
}

@Preview(showBackground = true)
@Composable
private fun MessageTextPreview() {
    BooksTheme {
        MessageText("Error desconocido")
    }
}