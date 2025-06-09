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
fun JustJogBottomNavigation(
    modifier: Modifier = Modifier
) {
    var bottomNavCurrentIndex: Int by remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        elevation = BottomNavigationDefaults.Elevation
    ) {
        JustJogBottomNavigationItems.entries.forEach { bottomNavItem ->
            BottomNavigationItem(
                selected = bottomNavItem.index == bottomNavCurrentIndex,
                onClick = {
                    bottomNavCurrentIndex = bottomNavItem.index
                },
                icon = {
                    Icon(
                        painterResource(bottomNavItem.icon),
                        contentDescription = "${bottomNavItem.itemName} Icon"
                    )
                },
                modifier = modifier,
                enabled = true,
                label = { Text(bottomNavItem.itemName) },
                alwaysShowLabel = false,
                selectedContentColor = Color.Yellow,
                unselectedContentColor = Color.LightGray
            )
        }
    }
}
