import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.BnpTestApp.koinCommon
import net.BnpTestApp.ui.mainScreen.MainScreen
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(koinCommon)
    }
    application {
        Window(onCloseRequest = ::exitApplication, title = "Bnp Test App") {
            MainScreen()
        }
    }
}