package com.devnolimit.geminiaidemo.ui.screens.textToText

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnolimit.geminiaidemo.BuildConfig
import com.devnolimit.geminiaidemo.utils.ModelConstants
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TextToTextVM  : ViewModel() {

    var contentState = MutableStateFlow<UiState>(UiState.Ideal)
        private set


    //Generative Model
    private val generativeModel by lazy {
        GenerativeModel(
            modelName = ModelConstants.GEMINI_PRO,
            apiKey = BuildConfig.apikey
        )
    }


    fun getContentData(text: String) = viewModelScope.launch {
        contentState.update { UiState.Loading }
        val response = generativeModel.generateContent(text)
        response.text?.let { data ->
            contentState.update { UiState.Success(data) }
        } ?: run {
            contentState.update { UiState.Error("Something Went Wrong.") }
        }
    }

}