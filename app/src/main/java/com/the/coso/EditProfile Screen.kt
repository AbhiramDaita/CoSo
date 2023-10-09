package com.the.coso

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.One
import com.the.coso.ui.theme.Sixteen
import com.the.coso.ui.theme.Twelve


@Composable
fun EditProfileScreen(navController: NavController){

    val user = Firebase.auth.currentUser

    val userName = user?.displayName
    val bio = "Hello there"

    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)
        ) {

            AppBar2("edit profile",navController, onClick = {})

            Spacer(modifier = Modifier.height(40.dp))
            if (user != null) {
                user.photoUrl?.let { EditPicture(it) }
            }
            Spacer(modifier = Modifier.height(15.dp))
            if (userName != null) {
                EditDetails(userName,"username", onClick = {
                    navController.navigate(Screens.EditName.route)
                })
            }
            Spacer(modifier = Modifier.height(15.dp))
            EditDetails(bio,"bio", onClick ={
                navController.navigate(Screens.BioUpdate.route)
            } )
        }
    }
}



@Composable
fun AppBar2(name : String,navController: NavController,onClick: () -> Unit){
    Row (modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier.weight(1f)) {
            AppBar(name,navController)
        }
        IconButton(onClick = {
            navController.popBackStack()
        }){
            Icon(Icons.Default.Check,contentDescription="null", modifier = Modifier.size(30.dp))
        }
    }
}

@Composable
fun EditDetails(detailName:String,label:String,onClick:()->Unit){
    Spacer(modifier = Modifier.height(25.dp))
    OutlinedTextField(value = detailName, onValueChange = {},
        label = {Text(label)},
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                       onClick()
            },
        textStyle = TextStyle(fontWeight = FontWeight.Medium, color = One),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Twelve,
        )
        , readOnly = true,
        enabled = false
    )
}



@Composable
fun EditPicture(imgUrl:Uri){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Box(modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.Blue)){
            AsyncImage(
                model = imgUrl,
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("edit picture", color = Sixteen, fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.clickable {

        })
    }
}

@Preview
@Composable
fun PrevEditProfile(){
    EditProfileScreen(rememberNavController())
}