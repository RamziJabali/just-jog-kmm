package ramzi.eljabali.justjogkmm.ui.navigation.navgraphs

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ramzi.eljabali.justjogkmm.ui.navigation.destinations.TabsGraph

@Composable
fun JustJogNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = TabsGraph.route,
        contentAlignment = Alignment.TopStart,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        tabsNavGraph(navController)
    }
}
