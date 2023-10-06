package com.the.coso

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun ClassRoomScreen(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White).padding(15.dp)) {
            Text("classroom", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally){
                Image(painter = painterResource(R.drawable.group_4), contentDescription = "a random image with a woman sitting")
                Text("join with invite", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text("you will get a invite link to your classroom", fontWeight = FontWeight.Normal, fontSize = 16.sp)
            }
        }
    }
}


@Preview
@Composable
fun PrevClassRoomScreen(){
    ClassRoomScreen(rememberNavController())
}