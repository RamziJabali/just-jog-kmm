package ramzi.eljabali.justjogkmm.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JustJogScaffold() {
    Box {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                JustJogBottomNavigation(
                    modifier = Modifier.navigationBarsPadding()
                )
            },
            floatingActionButton = { /* future requirement */ }
        ) { padding ->
        }
    }
}
