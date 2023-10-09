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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Four
import com.the.coso.ui.theme.One
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit


private lateinit var username : String
private lateinit var userCollege: String

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavHostController
    private var storedVerificationId: String? = ""
    private lateinit var resendToken : PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks : PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        auth = Firebase.auth
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                println("onVerificationCompleted: $p0");
            }

            override fun onVerificationFailed(e: FirebaseException) {
                if(e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid Request
                } else if (e is FirebaseTooManyRequestsException){
                    // The SMS quota for the project has been exceeded
                } else if (e is FirebaseAuthMissingActivityForRecaptchaException){
                    // reCAPTCHA verification attempted with null Activity
                }
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                storedVerificationId = p0
                resendToken = p1
                navController.navigate(Screens.Verification.route)
            }
        }
        
        setContent {

            navController = rememberNavController()
            SetupNavGraph(navController)
            setFun { startPhoneNumberVerification() }
            verifyFun { verifyPhoneNumberWithCode() }
            SetAuth { startPhoneNumberVerification() }

        }
    }


    private fun startPhoneNumberVerification(){
        val phoneNumber = getPhoneNumber()
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyPhoneNumberWithCode(){
        val code = getVerificationCode();
        val credential = PhoneAuthProvider.getCredential(storedVerificationId!!,code)
        if (credential.smsCode == code){
            signInWithPhoneAuthCredential(credential = credential)
        }

    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential){
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    if(navController.previousBackStackEntry?.destination?.route == Screens.Login.route){
                        navController.navigate(Screens.Home.route)
                    }else{
                        navController.navigate("GettingStartedTwo/${username}/${userCollege}")
                    }
                } else {
                    if(task.exception is FirebaseAuthInvalidCredentialsException){
                        // The verification code entered was invalid
                    }
                }
            }
    }

}
fun setDetails(name:String,college:String){
    username = name
    userCollege = college
}



@Composable
fun OnBoardingScreen(navController: NavController){
    if(Firebase.auth.currentUser != null){
        HomeScreen(navController)
    }
    else{
        CoSoTheme {
            Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp), verticalArrangement = Arrangement.Center) {
                Image(painterResource(R.drawable.group_3), contentDescription = "OnBoarding")
                Text("welcome", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(20.dp))

                TypewriterText(
                    texts = listOf("get the scoop on campus happenings. follow clubs, events, and campus organizations to stay in the know about all the exciting activities on and around your campus.",
                        "Experience college life like never before with our innovative social media app designed exclusively for students to connect, share, and thrive together on campus.",
                        "Introducing the college social media app that connects students, sparks conversations, and fosters a vibrant campus community like never before.")
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