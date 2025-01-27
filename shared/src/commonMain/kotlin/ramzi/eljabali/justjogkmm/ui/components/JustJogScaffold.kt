package ramzi.eljabali.justjogkmm.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JustJogScaffold() {
    Box(
        Modifier.navigationBarsPadding()
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { JustJogBottomNavigation() },
            floatingActionButton = { /* future requirement */ }
        ) { padding ->
            /* Content */
        }
    }
}