package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExploreScreen(navController: NavController){
    CoSoTheme {
        val rows = 3
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White).
        padding(bottom = 0.dp, top = 15.dp, start = 15.dp, end = 15.dp)) {
            item {
                AppBar("the art gallery")
                Spacer(modifier = Modifier.height(20.dp))
                FlowRow(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    maxItemsInEachRow = rows
                ){
                    val itemModifier = Modifier
                        .padding(4.dp)
                        .height(150.dp)
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Blue)
                    repeat(rows * 10){
                        Spacer(modifier = itemModifier)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PrevExplore(){
    ExploreScreen(rememberNavController())
}