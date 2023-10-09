package com.the.coso.ViewModels

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun FullScreenImage(navController: NavController,uri: Uri){
    CoSoTheme {
        Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
            IconButton(onClick = {
                navController.popBackStack()
            }){
                Icon(Icons.Default.Close, contentDescription = "close")
            }
            AsyncImage(
                model = uri,
                contentDescription = "artist",
                modifier = Modifier.height(400.dp).fillMaxWidth()
            )
        }
    }
}