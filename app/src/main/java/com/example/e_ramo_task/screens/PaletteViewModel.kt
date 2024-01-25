package com.example.e_ramo_task.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_ramo_task.Constants.IMAGE_1
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class PaletteViewModel : ViewModel() {

    private val _colorPalette: MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette: State<Map<String, String>> = _colorPalette

    fun setColorPalette(colors: Map<String, String>) {
        _colorPalette.value = colors
    }

    private val _uiState = MutableSharedFlow<UiEvent>()
    val uiState: SharedFlow<UiEvent> = _uiState.asSharedFlow()

    fun generatePaletteColor() {
        viewModelScope.launch {
            _uiState.emit(UiEvent.GenerateColorPalette)
        }
    }


}

sealed class UiEvent {
    object GenerateColorPalette : UiEvent()
}