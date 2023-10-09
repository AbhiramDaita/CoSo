package com.the.coso

import android.widget.Space
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme


@Composable
fun TimeTableScreen(navController: NavController){
    val monday = listOf("SPPM","Cloud Computing","CNS","Lunch","Data Mining","Project")
    val tuesday = listOf("Data Mining","Cloud Computing","CNS","Lunch","Data Mining","Project")
    val wednesday = listOf("CNS","Cloud Computing","CNS","Lunch","Data Mining","Project")
    val thursday = listOf("ES","Project","Cloud Computing","Lunch","Project","Data Mining")
    val friday = listOf("CNS","Cloud Computing","CNS","Lunch","Data Mining","Project")
    val saturday = listOf("Data Mining","Project","Project","Lunch","Data Mining","Club Activity")
    CoSoTheme {
        LazyColumn(modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)) {

            item{
                AppBar("time table",navController)
                Spacer(modifier = Modifier.height(35.dp))
                Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
                    DayComponent("monday", monday)
                    DayComponent("tuesday",tuesday)
                    DayComponent("wednesday",wednesday)
                    DayComponent("thursday",thursday)
                    DayComponent("friday",friday)
                    DayComponent("saturday",saturday)
                }
            }

        }
    }
}

@Composable
fun DayComponent(day:String,list:List<String>){
    val timings = listOf("10:00 - 11:00","11:00 - 12:00","12:00 - 13:00","13:00 - 14:00","15:00 - 16:00","16:00 - 17:00")
    Text(day, fontSize = 17.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
    val map : Map<String,String> = timings.zip(list).toMap()

    Column(verticalArrangement = Arrangement.spacedBy(15.dp)){
            map.iterator().forEach {
                Row{
                    Text(it.key, color = Color.Gray, fontSize = 16.sp, fontWeight = FontWeight.Normal)
                    Spacer(Modifier.width(15.dp))
                    Text(it.value, fontSize = 18.sp)
                }
            }
    }
}


