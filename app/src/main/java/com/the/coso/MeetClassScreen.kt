package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.the.coso.ui.theme.CoSoTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MeetClassScreen(navController: NavController){
    CoSoTheme {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)) {

            item {
                AppBar("meet your classmates",navController)
                Spacer(modifier = Modifier.height(40.dp))

                // Get Class Students List
                FlowRow(modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    maxItemsInEachRow = 3) {
                    MateComponent("Sam","")
                }
            }
        }
    }
}


@Composable
fun MateComponent(name:String,imgUrl:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(Color.Cyan)
                .size(70.dp)
        ){
            // Profile Picture
            AsyncImage(model = imgUrl,
                contentDescription = "profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(name, fontSize = 19.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun PrevMeet(){
    MeetClassScreen(rememberNavController())
}
