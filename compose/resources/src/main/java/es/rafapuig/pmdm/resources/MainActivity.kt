package es.rafapuig.pmdm.resources

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import es.rafapuig.pmdm.resources.ui.theme.PMDMComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val text = assets.open("greeting.txt")
            .bufferedReader().use {
                it.readText()
            }

        setContent {
            PMDMComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        text = text,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    val context = LocalContext.current

    val text = context.assets.open("greeting.txt")
        .bufferedReader().use {
            it.readText()
        }

    PMDMComposeTheme {
            Greeting(text)
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    PMDMComposeTheme(dynamicColor = true, darkTheme = true) {
            Image(
                painter = painterResource(R.drawable.spain),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.systemBars)
                    .background(MaterialTheme.colorScheme.primary)
            )
    }
}