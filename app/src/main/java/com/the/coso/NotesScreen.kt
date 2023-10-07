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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun NotesScreen(navController: NavController){
    CoSoTheme {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)) {

            item{
                AppBar("notes",navController)
                Spacer(modifier = Modifier.height(25.dp))
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    val list = listOf("chapter 1","chapter 2","chapter 3","chapter 4","chapter 5")
                    NoteComponent("machine learning",list)
                    NoteComponent("cloud computing",list)
                }
                Spacer(modifier = Modifier.height(60.dp))
                Row{
                    Image(painter = painterResource(R.drawable.long_road_svg), contentDescription = "notes")
                }
            }
        }
    }
}

@Composable
fun NoteComponent(subjectName:String,names:List<String>){
    Text(subjectName, color = Color.Gray, fontSize = 18.sp)
    names.forEach { it
        AboutComponent(it, onClick = {})
    }
}

@Preview
@Composable
fun PrevNotes(){
    NotesScreen(rememberNavController())
}