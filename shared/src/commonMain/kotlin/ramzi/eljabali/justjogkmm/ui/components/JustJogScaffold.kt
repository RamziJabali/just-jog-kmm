package ramzi.eljabali.justjogkmm.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun JustJogScaffold() {
    var navController = rememberNavController()
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
