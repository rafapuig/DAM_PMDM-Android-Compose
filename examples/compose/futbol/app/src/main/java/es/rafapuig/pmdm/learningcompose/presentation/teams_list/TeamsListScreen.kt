package es.rafapuig.pmdm.learningcompose.presentation.teams_list

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.rafapuig.pmdm.learningcompose.domain.teams
import es.rafapuig.pmdm.learningcompose.presentation.teams_list.components.TeamList
import es.rafapuig.pmdm.learningcompose.ui.theme.LearningComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamsListScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Equipos") }
            )
        }
    ) { innerPadding ->
        TeamList(
            teams = teams,
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TeamsListsScreenPreview() {
    LearningComposeTheme(darkTheme = true) {
        TeamsListScreen()
    }
}