package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun ClassRoomScreen(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White).
        wrapContentSize(align = Alignment.Center)) {
            Text("ClassRoom Screen")
        }
    }
}