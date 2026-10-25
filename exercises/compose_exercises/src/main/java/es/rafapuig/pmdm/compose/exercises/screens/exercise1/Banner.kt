package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import es.rafapuig.pmdm.compose.exercises.R


@Preview
@Composable
fun Banner(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(160.dp)
            .background(
                AppColor.Purple,
                RoundedCornerShape(10.dp)
            )
    ) {
        /**
         * Crear las referencias para cada composable dentro del ConstraintLayout
         */
        val (image, title, button) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.hapy_boy_with_books),
            contentDescription = "Banner Image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Programa de certificación\navanzada para ti",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp, top = 24.dp)
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = AppColor.Purple,
                containerColor = AppColor.LightPurple
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
                .constrainAs(button) {
                    top.linkTo(title.bottom)
                    start.linkTo(title.start)
                }
        ) {
            Text("Comprar ahora")
        }

    }
}
