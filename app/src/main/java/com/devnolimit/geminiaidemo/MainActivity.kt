package com.devnolimit.geminiaidemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devnolimit.geminiaidemo.ui.screens.chatBot.ChatBot
import com.devnolimit.geminiaidemo.ui.screens.imageAndText.ImageAndText
import com.devnolimit.geminiaidemo.ui.screens.streamDemo.StreamAi
import com.devnolimit.geminiaidemo.ui.screens.textToText.TextToTextAi
import com.devnolimit.geminiaidemo.ui.theme.GeminiAiDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeminiAiDemoTheme {
//                TextToTextAi()
//                ImageAndText()
//                ChatBot()
                StreamAi()
            }
        }
    }
}