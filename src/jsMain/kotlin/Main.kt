import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        val stateFlow = MutableStateFlow(0)
        val number = remember { mutableStateOf(0) }


        LaunchedEffect(key1 = null) {
            launch {
                while (true) {
                    delay(1000)
                    stateFlow.update { it + 1 }
                }
            }

            delay(5000)
            launch {
                stateFlow.collect {
                    number.value = it
                }
            }

        }


        Div {
            Text(number.value.toString())

        }
    }
}