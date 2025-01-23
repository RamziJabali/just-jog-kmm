package ramzi.eljabali.justjogkmm

import androidx.compose.ui.window.ComposeUIViewController
import ramzi.eljabali.justjogkmm.ui.GreetingView

fun MainViewController() = ComposeUIViewController {
    GreetingView(Greeting().greet())
}