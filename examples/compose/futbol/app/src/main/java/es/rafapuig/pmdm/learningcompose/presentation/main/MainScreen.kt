package es.rafapuig.pmdm.learningcompose.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.learningcompose.presentation.main.components.Greeting
import es.rafapuig.pmdm.learningcompose.ui.theme.LearningComposeTheme

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun MainScreenPreview() {
    LearningComposeTheme {
        MainScreen()
    }
}