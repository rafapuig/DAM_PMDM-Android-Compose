package es.rafapuig.pmdm.compose.exercises.screens.exercise1

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.rafapuig.pmdm.compose.exercises.R

data class BottomMenuItem(val label: String, val icon: Int)
@Preview
@Composable
fun MyBottomBar() {

    val bottomMenuItems = listOf(
        BottomMenuItem("Explorar", R.drawable.coding),
        BottomMenuItem("Lista deseos", R.drawable.megafono),
        BottomMenuItem("Mi curso", R.drawable.tablet),
        BottomMenuItem("Cuenta", R.drawable.games)
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar {
        bottomMenuItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(item.label, fontSize = 10.sp) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColor.Purple,
                    selectedTextColor = AppColor.Purple,
                    unselectedIconColor = AppColor.TextGray,
                    unselectedTextColor = AppColor.TextGray
                )
            )
        }
    }

}