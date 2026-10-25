package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryListItem(
    category: CategoryItemInfo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(
                    AppColor.LightPurple,
                    RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = category.icon),
                contentDescription = category.title,
                modifier = Modifier.size(30.dp),
                tint = AppColor.Purple
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = category.title,
            fontSize = 12.sp,
            color = AppColor.TextGray
        )
    }
}

class CategoryProvider : PreviewParameterProvider<CategoryItemInfo> {
    override val values: Sequence<CategoryItemInfo>
        get() = categories.asSequence()
}

@Preview(showBackground = true)
@Composable
fun CategoryListItemPreview(
    @PreviewParameter(CategoryProvider::class) category: CategoryItemInfo
) {
    CategoryListItem(category, modifier = Modifier.padding(8.dp).width(85.dp))
}
