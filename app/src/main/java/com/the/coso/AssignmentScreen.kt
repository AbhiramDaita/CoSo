package com.the.coso

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Fifteen
import com.the.coso.ui.theme.Sixteen

@Composable
fun AssignmentScreen(navController: NavController,name:String){
    CoSoTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)) {

            AppBar(name,navController)
            Spacer(modifier = Modifier.height(45.dp))
            Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
                QuestionComponent(1,"what is deep learning?")
                QuestionComponent(2,"what is KNN?")
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = {
                    // Open File Manager to select PDF.
                },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Fifteen,
                    )
                ){
                    Text("upload", fontSize = 19.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}


@Composable
fun QuestionComponent(number:Int,question:String){
    Text("question $number", fontSize = 17.sp, color = Color.Gray)
    Text(question, fontSize = 19.sp, fontWeight = FontWeight.Bold)
}

