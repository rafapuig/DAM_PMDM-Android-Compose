package es.rafapuig.pmdm.previewsdemo.tags.components

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.previewsdemo.tags.model.Tag
import es.rafapuig.pmdm.previewsdemo.tags.model.tags

@Composable
fun TagList(tags: List<Tag>) {
    FlowRow {
        tags.forEach { tag ->
            Tag(
                text = tag.name,
                color = tag.color
            )
        }
    }
}

@Preview
@Composable
fun TagListPreview() {
    TagList(tags = tags)
}