package net.BnpTestApp.ui.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import net.BnpTestApp.KoinResolver
import net.BnpTestApp.koinCommon
import org.koin.core.component.KoinComponent

class MainScreenViewModel: ViewModel(), KoinComponent {

    init {
        println("marc MainScreenViewModel initialized")
    }

    val _action = MutableSharedFlow<Unit>()
    val action = _action.asSharedFlow()

    fun handleEvent() {
        viewModelScope.launch {
            println("marc MainScreenViewModel handleEvent called")
            _action.emit(Unit)
        }
    }
}

// ViewModelFactory that retrieves the data repository for your app.
val mainViewModelFactory = viewModelFactory {
    initializer {
        KoinResolver.resolve<MainScreenViewModel>()
    }
}
