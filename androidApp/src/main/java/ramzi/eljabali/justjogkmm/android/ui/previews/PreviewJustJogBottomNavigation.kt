package ramzi.eljabali.justjogkmm.android.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ramzi.eljabali.justjogkmm.ui.components.JustJogBottomNavigation

@Composable
@Preview
fun PreviewJustJogBottomNavigation(){
    JustJogBottomNavigation(
        modifier = Modifier,
        navigateToStaticsScreen = {},
        navigateToCalendarScreen = {},
        navigateToSettingsScreen = {},
    )
}
