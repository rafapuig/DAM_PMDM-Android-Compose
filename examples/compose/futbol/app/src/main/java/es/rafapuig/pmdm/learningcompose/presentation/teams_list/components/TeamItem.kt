package es.rafapuig.pmdm.learningcompose.presentation.teams_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.learningcompose.domain.model.Team
import es.rafapuig.pmdm.learningcompose.domain.teams
import es.rafapuig.pmdm.learningcompose.presentation.badgeId

@Composable
fun TeamItem(
    team: Team,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(25))
            .background(Color.Blue.copy(alpha = 0.25f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        TeamBadge(
            team.badgeId,
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
        )
        Text(
            text = team.name,
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}


class TeamParameterProvider : PreviewParameterProvider<Team> {
    override val values: Sequence<Team>
        get() = teams.asSequence()
}


@Preview(showBackground = true)
@Composable
private fun TeamItemPreview(
    @PreviewParameter(TeamParameterProvider::class) team: Team
) {
    TeamItem(team, modifier = Modifier.fillMaxWidth())
}

