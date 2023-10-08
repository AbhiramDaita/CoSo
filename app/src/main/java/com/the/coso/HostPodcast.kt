package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Lato
import com.the.coso.ui.theme.One
import com.the.coso.ui.theme.Thirteen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostPodcast(navController: NavController){
    var title by rememberSaveable{ mutableStateOf("") }

    val categories = listOf("select a category","career choices","life")
    var expandedCategory by remember{ mutableStateOf(false) }
    var selectedCategory by remember{ mutableStateOf(categories[0])}

    CoSoTheme {
        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)){
            AppBar("host a podcast",navController)
            Spacer(modifier = Modifier.height(25.dp))
            // Title Input
            OutlinedTextField(value = title,
                onValueChange = {title = it},
                placeholder = {Text("enter title")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Thirteen,
                    unfocusedContainerColor = Thirteen,
                    unfocusedIndicatorColor = Thirteen,
                    focusedIndicatorColor = Thirteen,
                    cursorColor = One
                ), modifier = Modifier.fillMaxWidth())


            Spacer(modifier = Modifier.height(25.dp))

            // Category Input
            ExposedDropdownMenuBox(
                expanded = expandedCategory,
                onExpandedChange = {expandedCategory = !expandedCategory},
            ){
                OutlinedTextField(
                    modifier = Modifier.menuAnchor().fillMaxWidth(),
                    readOnly = true,
                    value = selectedCategory,
                    onValueChange = {},
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCategory)},
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Thirteen,
                        unfocusedIndicatorColor = Thirteen,
                        focusedContainerColor = Thirteen,
                        unfocusedContainerColor = Thirteen,
                    )
                    ,textStyle = TextStyle(fontFamily = Lato, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                )
                ExposedDropdownMenu(
                    expanded = expandedCategory,
                    onDismissRequest = {expandedCategory = false}
                ){
                    categories.forEach{ selectedOption ->
                        DropdownMenuItem(
                            text = {Text(selectedOption)},
                            onClick = {
                                selectedCategory = selectedOption
                                expandedCategory = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            ButtonComponent(onClick = {})
        }
    }
}

@Composable
fun AppBar(title : String,navController: NavController){
    IconButton(onClick = {
        navController.popBackStack()
    }){
        Icon(Icons.Default.ArrowBack,contentDescription="null", modifier = Modifier.size(30.dp))
    }
    Spacer(Modifier.height(20.dp))
    Text(title, fontWeight = FontWeight.Bold, fontSize = 28.sp)
}

