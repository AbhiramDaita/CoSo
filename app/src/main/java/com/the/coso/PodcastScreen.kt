package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun PodcastScreen(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)) {
            AppBar("College Life")

        }
    }
}


@Preview
@Composable
fun PrevPod(){
    PodcastScreen(rememberNavController())
}