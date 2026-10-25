package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun CategoriesList(
    categoriesList: List<CategoryItemInfo> = categories,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        categoriesList.forEach { category ->
            CategoryListItem(category, modifier = Modifier.weight(.25f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesListPreview() {
    CategoriesList(modifier = Modifier.padding(16.dp))
}