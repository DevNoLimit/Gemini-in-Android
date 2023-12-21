package com.devnolimit.geminiaidemo.ui.screens.textToText

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devnolimit.geminiaidemo.ui.screens.textToText.components.BodyComponent
import com.devnolimit.geminiaidemo.ui.screens.textToText.components.FooterComponent
import com.devnolimit.geminiaidemo.ui.screens.textToText.components.HeaderComponent

@Composable
fun TextToTextAi(
    viewModel: TextToTextVM = viewModel()
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        //Header
        HeaderComponent(modifier = Modifier)

        //Text
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            BodyComponent(modifier = Modifier, viewModel = viewModel)
        }


        //Footer (Edit Text)
        FooterComponent {
            viewModel.getContentData(it)
        }
    }



}