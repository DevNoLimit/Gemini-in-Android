package com.devnolimit.geminiaidemo.ui.screens.imageAndText

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devnolimit.geminiaidemo.ui.screens.imageAndText.components.ImageFooter
import com.devnolimit.geminiaidemo.ui.screens.imageAndText.components.ImageHeader
import com.devnolimit.geminiaidemo.ui.screens.imageAndText.components.ImageTextBody

@Composable
fun ImageAndText(
    viewModel: ImageAndTextVM = viewModel()
) {

    val context = LocalContext.current

    val pickImageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()){
        it?.let { uri ->
            val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ImageDecoder.decodeBitmap(
                    ImageDecoder.createSource(context.contentResolver ,uri)
                )
            } else {
                BitmapFactory.decodeFile(uri.path)
            }
            viewModel.imageList.add(bitmap)
        }
    }


   Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.fillMaxSize()
   ) {
       //Header
       ImageHeader()

       //Body
       Box(
           modifier = Modifier.weight(1f),
           contentAlignment = Alignment.Center
       ) {
           ImageTextBody(viewModel = viewModel)
       }

       //Footer
       ImageFooter(
           list = viewModel.imageList,
           pickImageClick = {
               pickImageLauncher.launch(
                   PickVisualMediaRequest(
                       mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                   )
               )
           },
           submitClick = {
               viewModel.generateContentData(it)
           }
       )
   }
}