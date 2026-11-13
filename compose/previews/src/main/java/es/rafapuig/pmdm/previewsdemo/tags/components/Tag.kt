package es.rafapuig.pmdm.previewsdemo.tags.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Tag(
    text: String,
    width: Dp? = null,
    color: Color = Color.Yellow
) {
    Text(
        text,
        Modifier
            .clip(RoundedCornerShape(30))
            .background(color)
            .padding(10.dp)
                then if (width != null) Modifier.width(width) else Modifier,
        textAlign = TextAlign.Center,
        color = Color.Blue
    )
}

@Preview
@Composable
fun TagPreview() {
    Tag("Hola Compose")
}