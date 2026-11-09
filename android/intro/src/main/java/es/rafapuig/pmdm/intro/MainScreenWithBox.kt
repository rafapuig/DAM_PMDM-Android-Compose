@file:OptIn(ExperimentalMaterial3Api::class)

package es.rafapuig.pmdm.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.intro.ui.theme.PMDMComposeTheme

@Composable
fun MainScreenWithBox() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan
        ))

    val windowInsets = WindowInsets.statusBars
        .union(WindowInsets.navigationBars)
        .add(
            WindowInsets(
                top = 16.dp,
                left = 8.dp,
                right = 8.dp,
                bottom = 24.dp
            )
        )

    Box(
        modifier = Modifier
            .windowInsetsPadding(windowInsets)
            .background(Color.White.copy(alpha = 0.85f))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.googlelogo_color_272x92dp),
                contentDescription = "Google logo"
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Hola Android!",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MainScreenWithBoxPreview() {
    PMDMComposeTheme {
        MainScreenWithBox()
    }
}