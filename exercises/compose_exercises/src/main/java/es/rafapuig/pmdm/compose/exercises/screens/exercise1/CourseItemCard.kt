package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import es.rafapuig.pmdm.compose.exercises.R

@Composable
fun CourseItemCard(
    course: CourseItemInfo,
    modifier: Modifier = Modifier
) {
    // Como una card
    Column(
        modifier = modifier
            .width(200.dp)
            .height(250.dp)
            .shadow(3.dp, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (
                image,
                title,
                profile,
                name,
                price,
                scoreRow
            ) = createRefs()

            Image(
                painter = painterResource(id = course.picUrl),
                contentDescription = course.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                    }
            )

            Text(
                text = course.title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColor.OverlayBlack)
                    .padding(8.dp)
                    // Overlay el título en la imagen
                    .constrainAs(title) {
                        bottom.linkTo(image.bottom)
                    }
            )
            Image(
                painter = painterResource(R.drawable.hapy_boy_with_books),
                contentDescription = course.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .
                    constrainAs(profile){
                        top.linkTo(image.bottom, margin = 8.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
            )

            Text(
                text = course.name,
                color = AppColor.TextGray,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(name) {
                        top.linkTo(profile.top)
                        start.linkTo(profile.end, margin = 8.dp)
                        bottom.linkTo(profile.bottom)
                    }
            )

            // Precio
            Text(
                text = "${course.price}€",
                color = AppColor.Purple,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .constrainAs(price) {
                        top.linkTo(profile.bottom, margin = 4.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                    }
            )

            //Score : Bottom-end
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .constrainAs(scoreRow) {
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                    }
            ) {
                Text(
                    text = course.score.toString(),
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    tint = AppColor.GoldYellow,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}


class CourseItemCardProvider : PreviewParameterProvider<CourseItemInfo> {
    override val values: Sequence<CourseItemInfo>
        get() = sampleCourses.take(3).asSequence()
}


@Preview
@Composable
fun CourseItemCardPreview(
    @PreviewParameter(CourseItemCardProvider::class) courseItem : CourseItemInfo
) {
    CourseItemCard(courseItem)
}