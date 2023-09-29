package com.the.coso

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Thirteen

@Composable
fun GettingStartedTwo(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(20.dp)){

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom){
                Text("profile picture", fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("2 / 3", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text("say cheese!", fontWeight = FontWeight.Light, fontSize = 17.sp)

            Spacer(modifier = Modifier.height(50.dp ))

            // Go to Gallery
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
                CamComponent(painterResource(R.drawable.image_add_fill),navController)
                CamComponent(painterResource(R.drawable.camera),navController)
            }
        }
    }
}

@Composable
fun CamComponent(painter:Painter,navController: NavController){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {
        navController.navigate(Screens.GettingStartedThree.route)
    }){
        Surface(shape = RoundedCornerShape(50), color = Thirteen, modifier = Modifier.size(110.dp)){
        }
        Icon(painter = painter,contentDescription="camera")
    }
}

@Preview
@Composable
fun PrevTwo(){
    GettingStartedTwo(rememberNavController())
}