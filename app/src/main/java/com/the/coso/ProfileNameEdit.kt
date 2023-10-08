package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Thirteen

@Composable
fun ProfileNameEdit(navController: NavController){

    // Change Default Profile Name.
    var profileName by rememberSaveable { mutableStateOf("") }
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)){
            AppBar2("name",navController)
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(value = profileName,
                onValueChange = {profileName = it},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Thirteen,
                    unfocusedContainerColor = Thirteen,
                    focusedIndicatorColor = Thirteen,
                    unfocusedIndicatorColor = Thirteen,
                ),
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(25.dp))
            Text("you can only change your name twice within 14 days.", color = Color.Gray, fontSize = 14.sp)
        }
    }
}
