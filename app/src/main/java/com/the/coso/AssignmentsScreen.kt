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
import androidx.compose.foundation.lazy.LazyColumn
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
fun AssignmentsScreen(navController: NavController){
    CoSoTheme {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)) {

            item {
                AppBar("assignments",navController)
                Spacer(modifier = Modifier.height(25.dp))
                Text("\"Assignments are not just tasks; they are opportunities for growth, learning, and the pursuit of excellence.\"", fontSize = 13.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center, lineHeight = 25.sp)

                Spacer(modifier = Modifier.height(50.dp))

                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    // Add Subjects from the database (later)
                    val list = listOf("assignment-1","assignment-2","assignment-3")
                    AssignmentList(list,"machine learning",navController)
                    AssignmentList(list,"cloud computing",navController)
                }
                Row {
                    Image(painter = painterResource(R.drawable.croods_svg), contentDescription = "mobile", modifier = Modifier.size(270.dp))
                }
            }

        }
    }
}


// Add list of assignments
@Composable
fun AssignmentList(list:List<String>,subjectName:String,navController: NavController){
    Text(subjectName, fontSize = 15.sp, color = Color.Gray)
    list.forEach { it
        AboutComponent(it, onClick = {
            navController.navigate("Assignment/$it")
        })
    }
}



