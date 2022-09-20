import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {

        val number = remember { mutableStateOf(0) }

        LaunchedEffect(key1 = null) {

            while (true) {
                delay(1000)
                number.value++
            }

        }

        Div {
            Text(number.value.toString())

        }
    }
}