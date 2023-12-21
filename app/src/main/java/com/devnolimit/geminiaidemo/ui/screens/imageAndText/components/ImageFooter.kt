package com.devnolimit.geminiaidemo.ui.screens.imageAndText.components

import android.graphics.Bitmap
import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnolimit.geminiaidemo.ui.screens.imageAndText.ImageAndTextVM
import com.devnolimit.geminiaidemo.ui.screens.textToText.components.FooterComponent

@Composable
fun ImageFooter(
    list: MutableList<Bitmap>? = null,
    pickImageClick: () -> Unit = {},
    submitClick: (text: String) -> Unit = {}
) {

    var inputText by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            //Text Field
            TextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                },
                leadingIcon = {
                    IconButton(onClick = { pickImageClick() }) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add",
                            modifier = Modifier
                                .size(30.dp),
                            tint = Color.Black)
                    }
                },
                placeholder = {
                    Text(text = "Enter Your Question")
                },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray)
            )

            //Button Icon
            IconButton(onClick = {
                submitClick(inputText)
                inputText = ""
            }) {
                Icon(
                    Icons.Default.Send,
                    contentDescription = "Send",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Black)
                        .padding(8.dp),
                    tint = Color.White
                )
            }
        }

        val data = list ?: emptyList()

        AnimatedVisibility(visible = data.isNotEmpty()) {
            Spacer(modifier = Modifier.size(10.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ){
                items(list ?: emptyList()){
                    Box(modifier = Modifier
                        .size(50.dp)
                        .padding(5.dp)
                    ){
                        Image(
                            it.asImageBitmap(),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ImageFooterPreview() {
    ImageFooter()
}