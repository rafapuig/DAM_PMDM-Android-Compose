package es.rafapuig.pmdm.compose.learning.components.text.annotated

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.Bullet
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun BulletListDemo(modifier: Modifier = Modifier) {

    val rectBullet = Bullet.Default.copy(shape = RectangleShape)
    val secondLevelBullet = Bullet.Default.copy(brush = SolidColor(Color.Red))

    val text = buildAnnotatedString {
        withBulletList(10.sp, bullet = rectBullet) {
            withBulletListItem { append("Unidad 1 - Introducción") }
            withBulletListItem {
                append("Unidad 2 - Conceptos")
                withBulletList(15.sp, bullet = secondLevelBullet) {
                    withBulletListItem { append("Composición") }
                    withBulletListItem { append("Estados") }
                }
            }
            withBulletListItem { append("Unidad 3 - Modificadores") }
            withBulletListItem { append("Unidad 4 - Layouts") }
        }
    }

    Text(text)

}