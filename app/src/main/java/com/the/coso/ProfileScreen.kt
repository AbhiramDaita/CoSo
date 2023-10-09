package com.the.coso

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.the.coso.DataClasses.Posts
import com.the.coso.ViewModels.ProfilePostsRepo
import com.the.coso.ViewModels.ProfilePostsViewModel
import com.the.coso.ViewModels.PublicPostsRepo
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Twelve
import java.lang.IllegalStateException

private lateinit var user : FirebaseUser

@SuppressLint("MutableCollectionMutableState")
@Composable
fun ProfileScreen(navController: NavController,
                  profilePostsViewModel: ProfilePostsViewModel = viewModel(factory = ProfilePostsViewModelFactory(ProfilePostsRepo()))){

    user = Firebase.auth.currentUser!!

    CoSoTheme {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 80.dp, top = 15.dp, start = 15.dp, end = 15.dp)) {
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()){
                    // Username
                    Text(user.displayName!!, fontSize =23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))

                    // To Settings
                    IconButton(onClick = {
                        navController.navigate(Screens.Settings.route)
                    }){
                        Icon(Icons.Default.Settings, contentDescription = "settings")
                    }

                }

                Spacer(modifier = Modifier.height(25.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Blue)){
                        // Profile Picture
                        AsyncImage(
                            model=user.photoUrl,
                            contentDescription = "Profile Picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Text(user.displayName!!, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(8.dp))
                        // Single Line Bio
                    }
                }

                Spacer(Modifier.height(15.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color = Twelve)

                val postsList = profilePostsViewModel.getProfilePosts(user.uid).collectAsState(initial = null).value

                val list = postsList?.toObjects(Posts::class.java)
                list?.forEach {
                    PostComponent(it.userName,it.post,it.userProfile,it.likes,it.comments)
                }
            }
        }
    }
}

class ProfilePostsViewModelFactory(private val profilePostsRepo: ProfilePostsRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfilePostsViewModel::class.java)){
            return ProfilePostsViewModel(profilePostsRepo) as T
        }
        throw IllegalStateException()
    }
}



@Preview
@Composable
fun PrevProf(){
    ProfileScreen(rememberNavController())
}