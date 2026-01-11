package net.BnpTestApp.ui.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import net.BnpTestApp.KoinResolver
import org.koin.core.component.KoinComponent

class MainScreenViewModel: ViewModel(), KoinComponent {

    val _action = MutableSharedFlow<Unit>()
    val action = _action.asSharedFlow()

    fun handleEvent() {
        viewModelScope.launch {
            _action.emit(Unit)
        }
    }
}

val mainViewModelFactory = viewModelFactory {
    initializer {
        KoinResolver.resolve<MainScreenViewModel>()
    }
}
