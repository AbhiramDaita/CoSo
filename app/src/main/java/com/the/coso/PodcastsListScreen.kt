package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Sixteen

@Composable
fun PodcastsListScreen(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Text("podcasts", fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Row {
                    Icon(painterResource(R.drawable.ep_mic), contentDescription = "mic", tint = Sixteen)
                    Text("host", color = Sixteen, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(35.dp))
            Column(verticalArrangement = Arrangement.spacedBy(25.dp)){
                ListComponent()
            }
        }
    }
}

@Composable
fun ListComponent(){
    Row(modifier = Modifier
        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            // Category
            Text("college", fontSize = 15.sp, fontWeight = FontWeight.Light)

            // Title
            Text("College Life", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            // hosted by
            Text("hosted by com", fontSize = 15.sp, fontWeight = FontWeight.Light)

        }

        // Number of listeners
        Row {
            Text("listen with 7 others", fontSize = 16.sp, fontWeight=FontWeight.Medium)
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "arrowforward")
        }
    }
    Divider()
}

