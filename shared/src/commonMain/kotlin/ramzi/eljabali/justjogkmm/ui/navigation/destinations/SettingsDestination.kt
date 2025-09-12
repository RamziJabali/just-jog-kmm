package ramzi.eljabali.justjogkmm.ui.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ramzi.eljabali.justjogkmm.ui.views.settings.SettingsView

fun NavGraphBuilder.settingsDestination() {
    composable(TabsGraph.SettingsScreen.route) {
        SettingsView()
    }
}

fun NavController.navigateToSettingsDestination() {
    this.navigate(TabsGraph.SettingsScreen.route) {
        launchSingleTop = true // avoid multiple copies
        restoreState = true // restore state if already in back stack
        // pop up to keep single instance of the tab
        popUpTo(TabsGraph.route) { saveState = true }
    }
}
