package ramzi.eljabali.justjogkmm

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ramzi.eljabali.justjogkmm.di.initKoin
import ramzi.eljabali.justjogkmm.ui.app.App

fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = { initKoin() }
) {
    App()
}
