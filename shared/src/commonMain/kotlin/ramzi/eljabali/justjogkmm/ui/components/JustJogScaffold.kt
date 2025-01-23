package ramzi.eljabali.justjogkmm.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JustJogScaffold() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { JustJogBottomNavigation() },
        floatingActionButton = { /* future requirement */ }
    ) {

    }
}