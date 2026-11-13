package es.rafapuig.pmdm.clean.books.feature.book.presentation.book_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import es.rafapuig.pmdm.clean.books.R
import es.rafapuig.pmdm.clean.books.feature.book.data.sampleBooks
import es.rafapuig.pmdm.clean.books.feature.book.domain.model.Book
import es.rafapuig.pmdm.clean.books.ui.theme.BooksTheme

@Composable
fun BookCoverImage(
    book: Book,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        var imageLoadResult by remember {
            mutableStateOf<Result<Painter>?>(null)
        }

        val painter = rememberAsyncImagePainter(
            model = book.imageUrl,
            onSuccess = {
                imageLoadResult =
                    if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                        Result.success(it.painter)
                    } else {
                        Result.failure(IllegalArgumentException("Invalid image size"))
                    }
            },
            onError = {
                it.result.throwable.printStackTrace()
                imageLoadResult = Result.failure(it.result.throwable)
            }
        )

        when (val result = imageLoadResult) {
            null -> CircularProgressIndicator()
            else -> {
                Image(
                    painter =
                        if (result.isSuccess) painter
                        else painterResource(id = R.drawable.book_error_2),
                    contentDescription = null,
                    contentScale =
                        if (result.isSuccess) ContentScale.Crop
                        else ContentScale.Fit,
                    modifier = Modifier.aspectRatio(
                        0.65f,
                        matchHeightConstraintsFirst = true
                    )
                )
            }
        }

    }
}

@Preview
@Composable
private fun BookCoverImagePreview() {
    BooksTheme {
        BookCoverImage(sampleBooks.first())
    }

}