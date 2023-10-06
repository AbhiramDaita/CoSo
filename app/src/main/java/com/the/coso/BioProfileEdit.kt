package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Thirteen

@Composable
fun BioProfileEditScreen(navController: NavController){
    var bio by rememberSaveable { mutableStateOf("") }
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)){
            AppBar2("bio",navController)
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(value = bio,
                onValueChange = {bio = it},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Thirteen,
                    unfocusedContainerColor = Thirteen,
                    focusedIndicatorColor = Thirteen,
                    unfocusedIndicatorColor = Thirteen,
                ),
                modifier = Modifier.fillMaxWidth())
        }
    }
}


@Preview
@Composable
fun PrevBioProfile(){
    BioProfileEditScreen(rememberNavController())
}