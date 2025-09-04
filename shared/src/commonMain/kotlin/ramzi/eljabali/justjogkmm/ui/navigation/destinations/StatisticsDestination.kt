package ramzi.eljabali.justjogkmm.ui.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ramzi.eljabali.justjogkmm.ui.views.StatisticsView

fun NavGraphBuilder.statisticsDestination() {
    composable<TabsGraph.StatisticsScreen> {
        StatisticsView()
    }
}

fun NavController.navigateToStatisticsDestination() {
    this.navigate(TabsGraph.StatisticsScreen) {
        launchSingleTop = true // avoid multiple copies
        restoreState = true // restore state if already in back stack
        // pop up to keep single instance of the tab
        popUpTo(TabsGraph) { saveState = true }
    }
}
