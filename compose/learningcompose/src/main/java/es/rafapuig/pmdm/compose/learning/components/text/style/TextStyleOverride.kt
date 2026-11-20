package es.rafapuig.pmdm.compose.learning.components.text.style

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.compose.learning.R
import es.rafapuig.pmdm.compose.learning.ui.theme.PMDMComposeTheme

@Composable
fun TextStyleOverrideDemo(modifier: Modifier = Modifier) {
    
    val originalStyle = LocalTextStyle.current

    val style  = TextStyle(
        color = Color.Red
    )
    Text(
        stringResource(R.string.hello_world),
        style = MaterialTheme.typography.bodySmall
        )
}

@Preview(showBackground = true, locale = "es")
@Composable
private fun TextStyleOverrideDemoPreview1() {

    TextStyleOverrideDemo()

}

@Preview(showBackground = true)
@Composable
private fun TextStyleOverrideDemoPreview2() {
    PMDMComposeTheme() {
        TextStyleOverrideDemo()
    }
}