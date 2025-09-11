package ramzi.eljabali.justjogkmm.ui.navigation.navgraphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.TabsGraph
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.calendarDestination
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.settingsDestination
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.statisticsDestination

fun NavGraphBuilder.tabsNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = TabsGraph.StatisticsScreen.route,
        route = TabsGraph.route
    ) {
        statisticsDestination()

        calendarDestination()

        settingsDestination()
    }
}
