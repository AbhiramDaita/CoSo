package com.the.coso

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Lato
import com.the.coso.ui.theme.One
import com.the.coso.ui.theme.Thirteen
import com.the.coso.ui.theme.Two

private lateinit var verification:()->Unit
private lateinit var verificationCode : String

@Composable
fun VerificationScreen(navController: NavHostController) {
    var code by rememberSaveable{ mutableStateOf("") }

    CoSoTheme {
        Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp)) {
            Row(modifier = Modifier.align(Alignment.End)){
                Image(painter = painterResource(R.drawable.orchids), modifier = Modifier.size(120.dp), contentDescription = "flowers")
            }
            Text("verification", fontSize = 45.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(15.dp))
            Text("enter verification code sent to your number", fontWeight = FontWeight.Light, fontSize = 17.sp)

            Spacer(modifier = Modifier.height(30.dp))

            // Verification Code Input
            OutlinedTextField(value = code,
                onValueChange = {code = it},
                modifier = Modifier.fillMaxWidth()
            , colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Thirteen,
                focusedContainerColor = Thirteen,
                unfocusedIndicatorColor = Thirteen,
                focusedIndicatorColor = Thirteen,
                cursorColor = Two,
            ), textStyle = TextStyle(fontFamily = Lato, fontWeight = FontWeight.Bold, fontSize = 17.sp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                Text("resend?", color = Color.Gray, fontSize = 17.sp)
            }
            Spacer(modifier = Modifier.height(60.dp))
            ButtonComponent(onClick = { onTap(code) })
        }
    }
}

fun getVerificationCode():String{
    return verificationCode
}


fun verifyFun(verify: () -> Unit){
    verification = verify
}

private fun onTap(code:String){
    verificationCode = code
    verification()
}
@Preview
@Composable
fun PreVerification(){
}