package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Sixteen
import com.the.coso.ui.theme.Thirteen
import com.the.coso.ui.theme.Two

@Composable
fun GetStartedOneScreen(){

    var name by rememberSaveable{ mutableStateOf("") }
    var phone by rememberSaveable{ mutableStateOf("") }
    var college by rememberSaveable{ mutableStateOf("") }

    CoSoTheme {
        Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom ){
                Text("get started",fontWeight=FontWeight.Bold,fontSize=40.sp,modifier = Modifier.weight(1f))
                Text("1 / 3", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text("let's get you in.", fontWeight = FontWeight.Light, fontSize = 17.sp )

            Spacer(modifier = Modifier.height(50.dp))

            // name input textField
            TextFieldComponent("enter name",name, onValueChange = {name = it})
            Spacer(modifier = Modifier.height(25.dp))

            // phone input textField
            TextFieldComponent("enter phone",phone, onValueChange = {phone = it})
            Spacer(modifier = Modifier.height(25.dp))


            // college input textField
            OutlinedTextField(value = college,
                onValueChange = {college = it},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Thirteen,
                    unfocusedContainerColor = Thirteen,
                    focusedIndicatorColor = Thirteen,
                    unfocusedIndicatorColor = Thirteen,
                ),
                placeholder = {Text("enter college")},
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = { TextButton(onClick = {}){
                    Text("verify", color = Sixteen)
                } })
            Spacer(Modifier.height(50.dp    ))
            ButtonComponent()
        }
    }
}

@Composable
fun TextFieldComponent(placeholder:String,value:String,onValueChange:(String)->Unit){
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(placeholder)},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Thirteen,
            focusedIndicatorColor = Thirteen,
            unfocusedIndicatorColor = Thirteen,
            focusedContainerColor = Thirteen,
            cursorColor = Two,
        ))
}

@Preview
@Composable
fun PrevOne(){
    GetStartedOneScreen()
}
