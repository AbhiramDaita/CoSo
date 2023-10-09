package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.One
import com.the.coso.ui.theme.Thirteen

@Composable
fun SearchScreen(navController: NavController){
    var searchQuery by rememberSaveable{ mutableStateOf(""  ) }
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)){
            OutlinedTextField(value = searchQuery,
                onValueChange = {searchQuery = it},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Thirteen,
                    focusedIndicatorColor = Thirteen,
                    unfocusedIndicatorColor = Thirteen,
                    unfocusedContainerColor = Thirteen,
                    cursorColor = One
                ),
                trailingIcon = {Icon(Icons.Outlined.Search,contentDescription="null")},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { IconButton(onClick = {
                    navController.popBackStack()
                }){
                    Icon(Icons.Outlined.ArrowBack,contentDescription = null, tint = Color.Black)
                } },
                placeholder = { Text("search...") },
                textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 17.sp))


                LazyColumn(Modifier.padding(15.dp)) {

                    // Change Spacing
                    item {

                    }
                }
        }
    }
}

@Composable
fun ResultComponent(){
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.Black)){
            // Profile Picture
            AsyncImage(
                model="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsynwv-5qtogtOwJbIjaPFJUmHpzhxgqIAug&usqp=CAU",
                contentDescription = "Profile Picture",
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        // Profile Name
        Text("marcus_magnus", fontSize = 19.sp)
    }
}


