package ramzi.eljabali.justjogkmm.ui.configuration

import just_jog_kmm.shared.generated.resources.Res
import just_jog_kmm.shared.generated.resources.calendar
import just_jog_kmm.shared.generated.resources.home
import org.jetbrains.compose.resources.DrawableResource


enum class JustJogBottomNavigationItems(val itemName: String, val icon: DrawableResource, val index: Int) {
    STATISTICS_BOTTOM_NAV_ITEM("Statistics", Res.drawable.home, 0),
    CALENDAR_BOTTOM_NAV_ITEM("Calendar", Res.drawable.calendar, 1)
}