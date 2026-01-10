import androidx.compose.ui.window.ComposeUIViewController
import net.BnpTestApp.koinCommon
import net.BnpTestApp.ui.mainScreen.MainScreen
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    startKoin {
        modules(koinCommon)
    }

    return ComposeUIViewController {
        MainScreen()
    }
}