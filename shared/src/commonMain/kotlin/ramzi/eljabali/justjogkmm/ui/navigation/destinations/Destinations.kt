package ramzi.eljabali.justjogkmm.ui.navigation.destinations

import kotlinx.serialization.Serializable

@Serializable object LoginScreen

@Serializable object TabsGraph {
    const val route = "tabs"

    @Serializable object StatisticsScreen {
        const val route = "tabs/statistics"
    }

    @Serializable object CalendarScreen {
        const val route = "tabs/calendar"
    }

    @Serializable object SettingsScreen {
        const val route = "tabs/settings"
    }
}
