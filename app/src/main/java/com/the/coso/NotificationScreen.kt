package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun NotificationScreen(navController: NavController){
    CoSoTheme {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)) {
            item {
                AppBar("notifications",navController)
            }
            item {

            }
        }
    }
}

@Composable
fun NotificationComponent(){

}

@Preview
@Composable
fun PrevNotification(){
    NotificationScreen(rememberNavController())
}