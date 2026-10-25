package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.compose.exercises.R

object AppColor {
    val Purple = Color(0xFF521C98)
    val LightPurple = Color(0xFFF0E9FA)
    val BgGray = Color(0xFFF8F8F8)
    val TextGray = Color(0xFF5E5E5E)
    val OverlayBlack = Color(0x90000000)
    val GoldYellow = Color(0xFFFFC107)
}

@Preview(showSystemUi = true)
@Composable
fun MyUI() {
    Scaffold(
        bottomBar = { MyBottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SearchRow()
            Banner()
            Categories()
            PopularCoursesHeader()
            CourseItemList()

            // Espacio extra para el scroll
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

}

@Composable
fun SearchRow() {
}