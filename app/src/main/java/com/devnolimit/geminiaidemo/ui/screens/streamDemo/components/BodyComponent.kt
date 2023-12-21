package com.devnolimit.geminiaidemo.ui.screens.streamDemo.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devnolimit.geminiaidemo.ui.screens.streamDemo.StreamVM
import com.devnolimit.geminiaidemo.ui.screens.textToText.TextToTextVM
import com.devnolimit.geminiaidemo.ui.screens.textToText.UiState

@Composable
fun BodyComponent(modifier: Modifier, viewModel: StreamVM) {

    val text by viewModel.responseText.collectAsStateWithLifecycle()

    SuccessBody(modifier = modifier, text)
}


@Composable
fun SuccessBody(modifier: Modifier, text: String){
    Text(
        text = text,
        modifier = modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    )
}

@Preview
@Composable
fun BodyComponentPreview(){
    SuccessBody(modifier = Modifier, "Body")
}