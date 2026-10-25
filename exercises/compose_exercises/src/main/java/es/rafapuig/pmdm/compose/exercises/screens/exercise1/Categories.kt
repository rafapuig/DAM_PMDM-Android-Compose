package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.compose.exercises.R

val categories = listOf(
    CategoryItemInfo("Marketing", R.drawable.megafono),
    CategoryItemInfo("Diseño", R.drawable.tablet),
    CategoryItemInfo("Juegos", R.drawable.games),
    CategoryItemInfo("Programación", R.drawable.coding)
)

@Preview(showBackground = true)
@Composable
fun Categories(
    categoriesList: List<CategoryItemInfo> = categories,
    header: @Composable () -> Unit = { CategoriesHeader() },
    content: @Composable (List<CategoryItemInfo>) -> Unit = { CategoriesList(it) }
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        header()
        Spacer(modifier = Modifier.height(16.dp))
        content(categoriesList)
    }
}

