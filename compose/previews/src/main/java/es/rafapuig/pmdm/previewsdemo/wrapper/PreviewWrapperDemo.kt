package es.rafapuig.pmdm.previewsdemo.wrapper

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewWrapper
import androidx.compose.ui.tooling.preview.PreviewWrapperProvider
import es.rafapuig.pmdm.previewsdemo.ui.theme.PMDMComposeTheme

private class ThemedScaffoldPreviewWrapper : PreviewWrapperProvider {
    @Composable
    override fun Wrap(
        content: @Composable (() -> Unit)
    ) {
        PMDMComposeTheme {
            Scaffold { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    content()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
@PreviewWrapper(wrapper = ThemedScaffoldPreviewWrapper::class)
private fun ThemedScaffoldWrapperPreview() {
    Text("Hola Preview Wrappers")
}

