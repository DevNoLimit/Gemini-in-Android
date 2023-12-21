package com.devnolimit.geminiaidemo.ui.screens.chatBot.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnolimit.geminiaidemo.ui.screens.chatBot.ChatData
import com.devnolimit.geminiaidemo.ui.screens.chatBot.ChatRoleEnum

@Composable
fun ChatListComponent(
    list: MutableList<ChatData>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        items(list){
            if (it.role == ChatRoleEnum.USER.role){
                UserChatMessage(message = it.message)
            } else {
                ModelChatMessage(message = it.message)
            }
        }
    }
}

@Composable
fun UserChatMessage(
    message: String
) {
    Text(
        text = message,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(12.dp),
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun ModelChatMessage(
    message: String
){
    Text(
        text = message,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(12.dp),
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    )
}