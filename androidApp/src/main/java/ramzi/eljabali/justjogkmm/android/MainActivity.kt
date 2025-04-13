package ramzi.eljabali.justjogkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ramzi.eljabali.justjogkmm.data.network.api.configuration.KtorClientPlatform
import ramzi.eljabali.justjogkmm.data.network.api.configuration.createHttpClient
import ramzi.eljabali.justjogkmm.ui.app.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    JustJogScaffold()
                    App(
                        client = remember {
                            createHttpClient(client = KtorClientPlatform().clientForPlatform)
                        }
                    )
                }
            }
        }
    }
}
