package es.rafapuig.pmdm.learningcompose.presentation.teams_list.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import es.rafapuig.pmdm.learningcompose.domain.model.Team
import es.rafapuig.pmdm.learningcompose.domain.teams
import es.rafapuig.pmdm.learningcompose.presentation.badgeId

@Composable
fun TeamBadge(
    @DrawableRes badgeId : Int,
    modifier: Modifier = Modifier
) {
    val painter = painterResource(badgeId)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier.aspectRatio(0.75f)
    )
}


@Preview(showBackground = true)
@Composable
fun TeamBadgePreview(
    @PreviewParameter(TeamParameterProvider::class) team: Team
) {
    TeamBadge(
        team.badgeId,
        modifier = Modifier.height(200.dp)
    )
}

class BadgeParameterProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = teams.map { it.badgeId }.asSequence()
}

@Preview(showBackground = true)
@Composable
fun TeamBadgePreviewFromResId(
    @PreviewParameter(BadgeParameterProvider::class) badgeId: Int
) {
    TeamBadge(
        badgeId,
        modifier = Modifier.height(200.dp)
    )
}