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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Lato
import com.the.coso.ui.theme.One
import com.the.coso.ui.theme.Ten
import com.the.coso.ui.theme.Thirteen
import com.the.coso.ui.theme.Two


@Composable
fun LoginScreen(navController: NavHostController) {
    var phone by rememberSaveable{mutableStateOf("")}
    val context = LocalContext.current
    CoSoTheme {
        Column(modifier = Modifier.fillMaxSize()
            .background(Color.White).padding(20.dp)){
            Row(modifier = Modifier.fillMaxWidth()){
            }

            Text("login", fontFamily = Lato, fontWeight = FontWeight.Bold, fontSize = 45.sp)
            Spacer(modifier = Modifier.height(15.dp))
            Text("enter your phone number or cell", fontFamily = Lato, fontWeight = FontWeight.Light, fontSize = 17.sp)
            Spacer(modifier = Modifier.height(35.dp))
            OutlinedTextField(value = phone, onValueChange = {phone = it},
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Thirteen,
                    unfocusedIndicatorColor = Thirteen,
                    focusedIndicatorColor = Thirteen,
                    cursorColor = Two,
                    focusedContainerColor = Thirteen
                ),
                leadingIcon = { Text("+91", fontFamily = Lato, fontWeight = FontWeight.Normal, color = Ten) },
                textStyle = TextStyle(fontFamily = Lato, fontWeight = FontWeight.Bold, fontSize = 17.sp),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Text("trouble logging in?", color = Color.Gray, fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(60.dp))

            ButtonComponent(onClick = {
                navController.navigate(Screens.Home.route)
            })
        }
    }
}

@Composable
fun ButtonComponent(onClick:()->Unit){
    Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        OutlinedButton(onClick = {onClick()}, colors = ButtonDefaults.outlinedButtonColors(
            contentColor = One
        ), shape = RoundedCornerShape(10.dp), modifier = Modifier.width(150.dp)
        ){
            Text("continue", fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }
    }
}

@Preview
@Composable
fun PreviewLogin(){
    LoginScreen(rememberNavController())
}