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
import ramzi.eljabali.justjogkmm.data.network.api.model.Quote
import ramzi.eljabali.justjogkmm.data.repositories.implementations.MotivationalQuotesRepositoryImpl

@Composable
fun App(client: MotivationalQuotesRepositoryImpl) {
    var errorState by remember { mutableStateOf<String?>(null) }
    var quote by remember { mutableStateOf<Quote?>(null) }
    val scope: CoroutineScope = rememberCoroutineScope()
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = quote?.quote ?: ""
    )

    Button(
        onClick = {
            scope.launch {
                when (val result = client.getRandomQuotes()) {
                    is ramzi.eljabali.justjogkmm.util.Result.Error<*> -> {
                        errorState = result.error.toString()
                    }

                    is ramzi.eljabali.justjogkmm.util.Result.Success<*> -> {
                        errorState = null
//                        motivationalQuote = result.data
                    }
                }
            }
        }
    ) {
        Text("Get Random Quote")
    }
}
