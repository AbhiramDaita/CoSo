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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Thirteen

@Composable
fun UserNameEditScreen(navController: NavController){

    // Change Default User Name
    var userName by rememberSaveable { mutableStateOf("") }

    var user = Firebase.auth.currentUser
    

    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)) {
            AppBar2("username",navController, onClick = {
                val profileUpdates = userProfileChangeRequest {
                    displayName = userName
                }
                user?.updateProfile(profileUpdates)
                    ?.addOnCompleteListener { task->
                        if(task.isSuccessful){
                            navController.popBackStack()
                        }
                    }
            })
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(value = userName,
                onValueChange = {userName = it},
                colors = TextFieldDefaults
                    .colors(
                        focusedIndicatorColor = Thirteen,
                        unfocusedIndicatorColor = Thirteen,
                        focusedContainerColor = Thirteen,
                        unfocusedContainerColor = Thirteen,
                    ),
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(25.dp))
            Text("you'll be able to change your username back to ${user?.displayName} for another 14 days.")
        }
    }
}

@Preview
@Composable
fun PrevUserName(){
    UserNameEditScreen(rememberNavController())
}