package com.example.effecthandlers.launched_effect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchedEffectViewModel : ViewModel() {
    private val _sharedFlow = MutableSharedFlow<ScreenEvent>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _sharedFlow.emit(ScreenEvent.ShowMessage("Hello World!"))
        }
    }
}

sealed class ScreenEvent {
    data class ShowMessage(val message:String) : ScreenEvent()
    data class Navigate(val route:String) : ScreenEvent()
}
