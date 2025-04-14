package ramzi.eljabali.justjogkmm.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import ramzi.eljabali.justjogkmm.ui.configuration.JustJogBottomNavigationItems

@Composable
fun JustJogBottomNavigation() {
    var bottomNavCurrentIndex: Int by remember { mutableStateOf(0) }
    BottomNavigation(
        modifier = Modifier,
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        elevation = BottomNavigationDefaults.Elevation
    ) {
        JustJogBottomNavigationItems.entries.forEach { bottomNavItem ->
            BottomNavigationItem(
                selected =
                if (bottomNavItem.index == bottomNavCurrentIndex) {
                    true
                } else {
                    false
                },
                onClick = {
                    bottomNavCurrentIndex = bottomNavItem.index
                },
                icon = {
                    Icon(
                        painterResource(bottomNavItem.icon),
                        contentDescription = "${bottomNavItem.itemName} Icon"
                    )
                },
                modifier = Modifier,
                enabled = true,
                label = { Text(bottomNavItem.itemName) },
                alwaysShowLabel = false,
                selectedContentColor = Color.Yellow,
                unselectedContentColor = Color.LightGray
            )
        }
    }
}
