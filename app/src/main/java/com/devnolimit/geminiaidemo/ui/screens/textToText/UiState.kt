package com.devnolimit.geminiaidemo.ui.screens.textToText

sealed class UiState(val data: String? = null, val error: String? = null) {

    data object Ideal : UiState()

    data object Loading: UiState()

    data class Success(val string: String) : UiState(data = string)

    data class Error(val string: String): UiState(error = string)

}