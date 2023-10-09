package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun AccountAboutScreen(navController: NavController){
   CoSoTheme {
       Column(modifier = Modifier
           .fillMaxSize()
           .background(Color.White)
           .padding(15.dp)) {

           AppBar("about your account",navController)

           Spacer(modifier = Modifier.height(25.dp))


           Row(verticalAlignment = Alignment.CenterVertically){
               Icon(painter = painterResource(R.drawable.calendar_month), contentDescription = "calender", modifier = Modifier.size(30.dp))
               Spacer(modifier=Modifier.width(30.dp))
               Column {
                   Text("date joined", fontSize = 18.sp)
                   Text("september 2020", fontSize = 15.sp, color = Color.Gray)
               }
           }

       }
   }
}


