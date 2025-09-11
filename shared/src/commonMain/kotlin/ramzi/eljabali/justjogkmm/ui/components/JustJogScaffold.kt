package ramzi.eljabali.justjogkmm.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.navigateToCalendarDestination
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.navigateToSettingsDestination
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.navigateToStatisticsDestination
import ramzi.eljabali.justjogkmm.ui.navigation.navgraphs.JustJogNavHost

@Composable
fun JustJogScaffold() {
    val navController = rememberNavController()
    Box {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                JustJogBottomNavigation(
                    modifier = Modifier.navigationBarsPadding(),
                    navigateToStaticsScreen = { navController.navigateToStatisticsDestination() },
                    navigateToCalendarScreen = { navController.navigateToCalendarDestination() },
                    navigateToSettingsScreen = { navController.navigateToSettingsDestination() }
                )
            },
            floatingActionButton = { /* future requirement */ }
        ) { innerPadding ->
            JustJogNavHost(navController, innerPadding)
        }
    }
}
