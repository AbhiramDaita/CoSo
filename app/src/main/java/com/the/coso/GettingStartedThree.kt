package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Lato
import com.the.coso.ui.theme.Thirteen


    
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GettingStartedThree(navController: NavHostController) {

    // Course Selector Variables
    val courses = listOf("select college","Computer Science and Engineering","Civil Engineering")
    var expandedCourse by remember { mutableStateOf(false) }
    var selectedCourse by remember { mutableStateOf(courses[0]) }

    // Year Selector Variables
    val years = listOf("select year","1","2","3","4")
    var expandedYear by remember{ mutableStateOf(false) }
    var selectedYear by remember { mutableStateOf(years[0]) }

    var about by remember { mutableStateOf("") }

    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)){

            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom){
                Text("profile", fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("3 / 3", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text("one last step and we are in", fontWeight = FontWeight.Light, fontSize = 17.sp)

            Spacer(Modifier.height(50.dp))

            // Course DropDown Selector
            ExposedDropdownMenuBox(
                expanded = expandedCourse,
                onExpandedChange = {expandedCourse = !expandedCourse },
            ){
                OutlinedTextField(
                    modifier = Modifier.menuAnchor().fillMaxWidth(),
                    readOnly = true,
                    value = selectedCourse,
                    onValueChange = {},
                    trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCourse)},
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Thirteen,
                        unfocusedIndicatorColor = Thirteen,
                        focusedContainerColor = Thirteen,
                        unfocusedContainerColor = Thirteen,
                    )
                    ,textStyle = TextStyle(fontFamily = Lato, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                )
                ExposedDropdownMenu(
                    expanded = expandedCourse,
                    onDismissRequest = {expandedCourse = false}
                ){
                    courses.forEach{ selectedOption ->
                        DropdownMenuItem(
                            text = {Text(selectedOption)},
                            onClick = {
                                selectedCourse = selectedOption
                                expandedCourse = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
            }

            Spacer(Modifier.height(30.dp))

            // Year DropDown Selector
            ExposedDropdownMenuBox(
                expanded = expandedYear,
                onExpandedChange = {expandedYear = !expandedYear},
            ){
                OutlinedTextField(
                    modifier = Modifier.menuAnchor().fillMaxWidth(),
                    readOnly = true,
                    value = selectedYear,
                    onValueChange = {},
                    trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedYear)},
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Thirteen,
                        unfocusedIndicatorColor = Thirteen,
                        focusedContainerColor = Thirteen,
                        unfocusedContainerColor = Thirteen,
                    )
                    ,textStyle = TextStyle(fontFamily = Lato, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                )
                ExposedDropdownMenu(
                    expanded = expandedYear,
                    onDismissRequest = {expandedYear = false}
                ){
                    years.forEach{ selectedOption ->
                        DropdownMenuItem(
                            text = {Text(selectedOption)},
                            onClick = {
                                selectedYear = selectedOption
                                expandedYear = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(30.dp))

            // about input textField
            OutlinedTextField(value = about,
                onValueChange = {about = it},
                modifier = Modifier.fillMaxWidth()
                    .height(200.dp),
                placeholder = {Text("about.")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Thirteen,
                    unfocusedContainerColor = Thirteen,
                    focusedIndicatorColor = Thirteen,
                    unfocusedIndicatorColor = Thirteen,

                ),
                textStyle = TextStyle(fontFamily = Lato, fontWeight = FontWeight.Bold, fontSize = 17.sp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(onClick = {
                val user = Firebase.auth.currentUser
                val db = Firebase.firestore
                val data = hashMapOf(
                    "course" to selectedCourse,
                    "year" to selectedYear,
                    "about" to about
                )
                db
                    .collection("users")
                    .document(user!!.uid)
                    .set(data)
                    .addOnCompleteListener {
                        navController.popBackStack(
                            route = Screens.Home.route,
                            inclusive = false
                        )
                    }
            })
        }
    }
}


@Preview
@Composable
fun PrevThree(){
    GettingStartedThree(rememberNavController())
}