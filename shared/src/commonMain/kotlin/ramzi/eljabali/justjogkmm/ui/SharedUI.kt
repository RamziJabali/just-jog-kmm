package ramzi.eljabali.justjogkmm.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun GreetingView(name: String) {
    var counterMutableState by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello $name!")
        Button(onClick = { counterMutableState++ }) {
            Text("+ 1")
        }
        TextButton(onClick = { counterMutableState++ }) {
            Text("Counter: $counterMutableState")
        }

        Button(onClick = { counterMutableState = 0 }) {
            Text("Reset Counter")
        }
    }
}