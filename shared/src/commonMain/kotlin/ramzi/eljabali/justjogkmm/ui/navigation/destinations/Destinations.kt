package ramzi.eljabali.justjogkmm.ui.navigation.destinations

import kotlinx.serialization.Serializable

@Serializable object LoginScreen

@Serializable object TabsGraph {
    @Serializable object StatisticsScreen {
        val route = this.toString()
    }

    @Serializable object CalendarScreen

    @Serializable object SettingsScreen
}
