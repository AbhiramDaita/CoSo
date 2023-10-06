package com.the.coso


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.the.coso.ui.theme.CoSoTheme


private lateinit var user : FirebaseUser


@Composable
fun SettingsScreen(navController: NavController){

    user = Firebase.auth.currentUser!!

    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)){
            AppBar("settings",navController)
            Spacer(modifier = Modifier.height(40.dp))
            Column(verticalArrangement = Arrangement.spacedBy(30.dp))    {
                SettingComponent(icon = painterResource(R.drawable.person) ,"edit profile", onClick = {
                    navController.navigate(Screens.EditProfileScreen.route)
                })
                SettingComponent(painterResource(R.drawable.help),"help", onClick = {
                    navController.navigate(Screens.HelpScreen.route)
                })
                SettingComponent(painterResource(R.drawable.outline_info_24),"about", onClick = {
                    navController.navigate(Screens.AboutScreen.route)
                })
                Text("logout", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFF6969),
                    modifier = Modifier.clickable {
                        Firebase.auth.signOut()
                    })
            }
        }
    }
}

@Composable
fun SettingComponent(icon:Painter,name:String,onClick:()->Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)){
        Icon(icon,contentDescription=name, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(15.dp))
        Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun PrevSetting(){
    CoSoTheme {
        SettingsScreen(rememberNavController())
    }
}