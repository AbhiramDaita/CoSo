package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun DiscussionsScreen(navController: NavController){
    CoSoTheme { 
        LazyColumn (modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)){
            item {
                AppBar("discussions",navController)
                Column {
                    Spacer(modifier = Modifier.height(30.dp))
                    DiscussionComponent("how to read books","sam")
                    Spacer(modifier = Modifier.height(20.dp))
                    Divider()
                }
            }
        }
    }
}

@Composable
fun DiscussionComponent(question:String,name:String){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(question, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("by $name", fontSize = 17.sp, fontWeight = FontWeight.Light)
        }
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = "arrowgo")
    }
}


@Preview
@Composable
fun PrevDiscussion(){
    DiscussionsScreen(rememberNavController())
}