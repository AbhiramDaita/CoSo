package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.One
import com.the.coso.ui.theme.Twelve

@Composable
fun ProfileScreen(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()){
                // Username
                Text("not_marcus", fontSize =23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))

                // To Settings
                IconButton(onClick = {}){
                    Icon(Icons.Default.Settings, contentDescription = "settings")
                }

            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                Box(modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.Blue)){
                    // Profile Picture
                    AsyncImage(
                        model="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsynwv-5qtogtOwJbIjaPFJUmHpzhxgqIAug&usqp=CAU",
                        contentDescription = "Profile Picture"
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))

                Column {
                    Text("Marcus Magnus", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    // Single Line Bio
                    Text("the go-to guy of CS", fontSize = 16.sp)
                }
            }

            Spacer(Modifier.height(15.dp))
            Divider(modifier = Modifier.fillMaxWidth(), color = Twelve)
        }
    }
}


@Preview
@Composable
fun PrevProf(){
    ProfileScreen(rememberNavController())
}