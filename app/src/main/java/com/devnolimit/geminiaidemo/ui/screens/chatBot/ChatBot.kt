package com.devnolimit.geminiaidemo.ui.screens.chatBot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.devnolimit.geminiaidemo.ui.screens.chatBot.componentes.ChatFooter
import com.devnolimit.geminiaidemo.ui.screens.chatBot.componentes.ChatHeader
import com.devnolimit.geminiaidemo.ui.screens.chatBot.componentes.ChatListComponent

@Composable
fun ChatBot(
    viewModel: ChatBotVM = viewModel()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        //Header
        ChatHeader()

        //Chat List
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (viewModel.list.isNotEmpty()){
                ChatListComponent(
                    list = viewModel.list
                )
            } else {
                Text(text = "No Chat Available.")
            }

        }

        //Footer
        ChatFooter {
            if (it.isNotEmpty()){
                viewModel.sendMessage(it)
            }
        }
    }
}