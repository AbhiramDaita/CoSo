package com.the.coso



import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Thirteen


private lateinit var user : FirebaseUser

@Composable
fun GettingStartedTwo(navController: NavController,Name:String?,College:String?){

    user = Firebase.auth.currentUser!!
    CoSoTheme {
        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(20.dp)){

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom){
                Text("profile picture", fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("2 / 3", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text("say cheese!", fontWeight = FontWeight.Light, fontSize = 17.sp)

            Spacer(modifier = Modifier.height(50.dp ))

            // Go to Gallery
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
                CamComponent(painterResource(R.drawable.image_add_fill),navController,"toGallery")
                val db = Firebase.firestore
                val profileUpdates = userProfileChangeRequest {
                    displayName = Name

                }
                val data = hashMapOf(
                    "name" to Name,
                    "college" to College,
                )
                user!!.updateProfile(profileUpdates)
                    .addOnCompleteListener {
                            db
                            .collection("users")
                            .document(user.uid)
                            .set(data)
                            .addOnSuccessListener {
                                Log.d("Message","Entry Done")
                            }
                            .addOnFailureListener {
                                Log.d("Error Message","failure")
                            }
                    }
            }
        }
    }
}



@Composable
fun CamComponent(painter:Painter, navController: NavController,to:String){
    var clicked by remember { mutableIntStateOf(0) }

    if(clicked == 1 && to == "toGallery"){

        val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
            onResult = {uri ->
                val profileUpdates = userProfileChangeRequest {
                    photoUri = uri
                }
                user!!.updateProfile(profileUpdates)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            navController.navigate(Screens.GettingStartedThree.route)
                        }
                    }
            }
        )



        // Take a look at the Effect API.
        SideEffect{
            singlePhotoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {
        clicked = 1
    }){
        Surface(shape = RoundedCornerShape(50), color = Thirteen, modifier = Modifier.size(110.dp)){
        }
        Icon(painter = painter,contentDescription="camera")
    }
}

@Preview
@Composable
fun PrevTwo(){
    GettingStartedTwo(rememberNavController(),"","")
}