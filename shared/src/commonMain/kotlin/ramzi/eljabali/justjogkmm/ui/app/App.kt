package ramzi.eljabali.justjogkmm.ui.app

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ramzi.eljabali.justjogkmm.data.network.api.model.MotivationalQuote

@Composable
fun App(client: Moti){
    var errorState by remember { mutableStateOf<String?>(null) }
    var motivationalQuote by remember { mutableStateOf<MotivationalQuote?>(null)}
    val scope: CoroutineScope = rememberCoroutineScope()
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = motivationalQuote?.quote ?: ""
    )

    Button(
        onClick = {
            scope.launch {

            }
        }
    )
}