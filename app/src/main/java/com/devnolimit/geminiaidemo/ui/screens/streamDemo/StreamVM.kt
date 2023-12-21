package com.devnolimit.geminiaidemo.ui.screens.streamDemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnolimit.geminiaidemo.BuildConfig
import com.devnolimit.geminiaidemo.utils.ModelConstants
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StreamVM  : ViewModel() {

    var responseText = MutableStateFlow<String>("")
        private set


    //Generative Model
    private val generativeModel by lazy {
        GenerativeModel(
            modelName = ModelConstants.GEMINI_PRO,
            apiKey = BuildConfig.apikey
        )
    }


    fun getContentData(text: String) = viewModelScope.launch {
        responseText.update { "" }
        generativeModel.generateContentStream(text).collect { chunk ->
            val oldText: String = responseText.value
            val newText = oldText + chunk.text
            responseText.update { newText }
        }
    }

}