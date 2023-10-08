package com.the.coso


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun AboutScreen(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)) {
            AppBar("about",navController)
            Spacer(modifier = Modifier.height(25.dp))
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                AboutComponent("about your account", onClick = {navController.navigate(Screens.AccountAbout.route)})
                AboutComponent("privacy policy", onClick = {navController.navigate(Screens.PrivacyScreen.route)})
                AboutComponent("terms of use", onClick = {navController.navigate(Screens.TermsUse.route)})
            }
        }
    }
}


@Composable
fun AboutComponent(name:String,onClick:()->Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onClick()
        }){
        Text(name, fontSize = 17.sp, modifier = Modifier.weight(1f))
            Icon(Icons.Outlined.KeyboardArrowRight,contentDescription = "null")
    }
}


