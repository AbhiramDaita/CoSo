package com.the.coso

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme


@Composable
fun Class(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)){

            AppBar("class : 4-1",navController)
            Spacer(modifier = Modifier.height(15.dp))
            Text("\"Classrooms are not just rooms filled with desks and chairs; they are the incubators of knowledge, the crucibles of curiosity, and the launchpads of lifelong learning.\"", textAlign = TextAlign.Center, lineHeight = 23.sp, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(40.dp))

           Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
               AboutComponent("assignments", onClick = {
                   navController.navigate(Screens.Assignments.route)
               })
               AboutComponent("notes", onClick = {
                   navController.navigate(Screens.Notes.route)
               })
               AboutComponent("time table", onClick = {
                   navController.navigate(Screens.TimeTable.route)
               })
               AboutComponent("discussions", onClick = {
                   navController.navigate(Screens.Discussions.route)
               })
               AboutComponent("meet your class", onClick = {
                   navController.navigate(Screens.MeetClass.route)
               })

           }
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier.align(Alignment.End)) {
                Image(painter = painterResource(R.drawable.class_math), contentDescription = "class_math", modifier = Modifier.size(200.dp))
            }
        }
    }
}

