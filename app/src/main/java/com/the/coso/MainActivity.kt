package com.the.coso

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Four
import com.the.coso.ui.theme.One
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SetupNavGraph(navController)

        }
    }
}

@Composable
fun OnBoardingScreen(navController: NavController){
    CoSoTheme {
        Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp), verticalArrangement = Arrangement.Center) {
            Image(painterResource(R.drawable.group_3), contentDescription = "OnBoarding")
            Text("welcome", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))

            TypewriterText(
                texts = listOf("get the scoop on campus happenings. follow clubs, events, and campus organizations to stay in the know about all the exciting activities on and around your campus.")
            )
            Spacer(modifier = Modifier.height(50.dp))
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom){
                Button(onClick = {
                                 navController.navigate(Screens.GetStartedOne.route)
                }
                    ,colors = ButtonDefaults.buttonColors(containerColor = Four),
                    shape = RoundedCornerShape(10.dp)){
                    Text("get started", color = One, fontWeight = FontWeight.Bold)
                }
                OutlinedButton(onClick = {
                                         navController.navigate(Screens.Login.route)
                }, shape = RoundedCornerShape(10.dp), modifier = Modifier.width(117.dp)){
                    Text("login", color = One, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun TypewriterText(
    texts: List<String>,
) {
    var textIndex by remember {
        mutableStateOf(0)
    }
    var textToDisplay by remember {
        mutableStateOf("")
    }
    val textCharsList: List<List<String>> = remember {
        texts.map { text ->
            text.map {
                it.toString()
            }
        }
    }

    LaunchedEffect(
        key1 = texts,
    ) {
        while (textIndex < textCharsList.size) {
            textCharsList[textIndex].forEachIndexed { charIndex, _ ->
                textToDisplay = textCharsList[textIndex]
                    .take(
                        n = charIndex + 1,
                    ).joinToString(
                        separator = "",
                    )
                delay(30)
            }
            textIndex = (textIndex + 1) % texts.size
            delay(30)
        }
    }

    Text(
        text = textToDisplay,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 25.sp,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OnBoardingScreen(rememberNavController())
}