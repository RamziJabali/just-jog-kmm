package ramzi.eljabali.justjogkmm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.TabsGraph

@Composable
fun JustJogNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = TabsGraph) {
    }
}
