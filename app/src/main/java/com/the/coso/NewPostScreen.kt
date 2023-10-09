package com.the.coso


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.One
import com.the.coso.ui.theme.Thirteen
import java.text.SimpleDateFormat
import java.util.Calendar





@Composable
fun NewPostScreen(navController: NavController){

    var post by rememberSaveable { mutableStateOf("") }

    val user = Firebase.auth.currentUser!!

    CoSoTheme {
       LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)
           .imePadding()) {
            item {

                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Close,contentDescription="close", modifier = Modifier.size(35.dp).clickable {
                        navController.popBackStack()
                    })
                    Spacer(modifier = Modifier.width(20.dp))
                    Box(modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Blue)
                    ){
                        // Profile Picture
                        AsyncImage(
                            model=user.photoUrl,
                            contentDescription = "Profile Picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = {

                        val time = Calendar.getInstance().time
                        val formatter = SimpleDateFormat("dd-MM-yyyy HH::mm")
                        val current = formatter.format(time)

                        val data = hashMapOf(
                            "post" to post,
                            "date" to current,
                            "likes" to 0,
                            "comments" to 0,
                            "userID" to user.uid,
                            "userName" to user.displayName,
                            "userProfile" to user.photoUrl
                        )
                        val db = Firebase.firestore
                        val publicRef = db.collection("posts")
                        val userRef = db.collection("users").document(user.uid).collection("posts")

                        userRef
                                .add(data)
                                .addOnSuccessListener {
                                    Log.d("Message","Document data received")
                                    navController.popBackStack()
                                }
                                .addOnFailureListener{
                                    Log.d("Error Message","Document data not received")
                                }

                        publicRef.add(data)
                            .addOnSuccessListener {
                                Log.d("Message","Document data received")
                            }
                            .addOnFailureListener {
                                Log.d("Error Message","Document data not received")
                            }


                    }){
                        Text("post", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(value = post,
                    onValueChange = {post = it},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        cursorColor = One,
                    ),
                    placeholder = {Text("what do you want to talk about?")},
                    textStyle = TextStyle(lineHeight = 23.sp, fontWeight = FontWeight.Medium, fontSize = 19.sp)
                )

            }
        }
    }
}


@Preview
@Composable
fun PrevNewPost(){
    NewPostScreen(rememberNavController())
}