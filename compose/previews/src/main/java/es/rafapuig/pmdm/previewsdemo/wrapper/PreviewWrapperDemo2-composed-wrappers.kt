package es.rafapuig.pmdm.previewsdemo.wrapper

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewWrapper
import androidx.compose.ui.tooling.preview.PreviewWrapperProvider
import es.rafapuig.pmdm.previewsdemo.ui.theme.PMDMComposeTheme

/**
 * Podemos crear varios PreviewWrapperProvider
 * y luego combinar sus efectos
 */

private class ThemeWrapper : PreviewWrapperProvider {
    @Composable
    override fun Wrap(content: @Composable (() -> Unit)) {
        PMDMComposeTheme { content() }
    }
}

private class ScaffoldWrapper : PreviewWrapperProvider {
    @Composable
    override fun Wrap(content: @Composable (() -> Unit)) {
        Scaffold { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                content()
            }
        }
    }
}

private class ThemedScaffoldWrapper : PreviewWrapperProvider {
    private val themeWrapper = ThemeWrapper()
    private val scaffoldWrapper = ScaffoldWrapper()

    @Composable
    override fun Wrap(content: @Composable (() -> Unit)) {
        themeWrapper.Wrap { scaffoldWrapper.Wrap { content() } }
    }
}

@Preview(showSystemUi = true)
@Composable
@PreviewWrapper(wrapper = ThemedScaffoldWrapper::class)
private fun ThemedScaffoldWrapperPreview() {
    Text("Hola Combined Preview Wrappers")
}

