package com.the.coso


import android.annotation.SuppressLint
import android.widget.Space
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.firebase.firestore.ktx.toObjects
import com.the.coso.DataClasses.Posts
import com.the.coso.ViewModels.PublicPostsRepo
import com.the.coso.ViewModels.PublicPostsViewModel
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Thirteen
import com.the.coso.ui.theme.Twelve
import java.lang.IllegalStateException


@SuppressLint("MutableCollectionMutableState")
@Composable
fun HomeScreen(navController : NavController){
    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Explore,
        BottomNavigationScreens.Podcast,
        BottomNavigationScreens.ClassRoom,
        BottomNavigationScreens.Profile
    )

    CoSoTheme {
        BackHandler(true, onBack = {
            navController.previousBackStackEntry?.destination?.route?.let {
                navController.navigate(
                    it
                )
            }
        })

        Scaffold(bottomBar = {
            NavigationBar(
                containerColor = Twelve,
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavigationItems.forEach { screen ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.White
                        ),
                        icon = { Icon(painterResource(screen.resourceId),contentDescription="null")},
                        selected = currentDestination?.hierarchy?.any{it.route == screen.route} == true,
                        onClick = {
                            navController.navigate(screen.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }) { padding->
            val padding = Modifier.padding(padding)
            HomeS(navController,padding)
        }
    }
}


@Composable
fun HomeS(
    navController: NavController,
    modifier: Modifier,
    publicPostsViewModel: PublicPostsViewModel = viewModel(factory = PublicPostsViewModelFactory(
        PublicPostsRepo()
    ))
){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.White)) {
        LazyColumn(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
            item{
                AppBar3(navController)
            }
            item {
                Spacer(modifier = Modifier.height(25.dp))
                OutlinedTextField(value = "write something...",
                    onValueChange = {},
                    colors = TextFieldDefaults.colors(
                        disabledContainerColor = Thirteen,
                        disabledIndicatorColor = Thirteen
                    ),
                    enabled = false,
                    modifier = Modifier.fillMaxWidth()
                        .clickable { navController.navigate(Screens.NewPostScreen.route) },
                    textStyle = TextStyle(fontWeight = FontWeight.Bold),
                )
            }
            item {
                Spacer(modifier = Modifier.height(25.dp))
                val postsList = publicPostsViewModel.getPublicPostsInfo().collectAsState(initial = null).value

                val list = postsList?.toObjects(Posts::class.java)
                list?.forEach {
                    PostComponent(it.userName,it.post,it.userProfile,it.likes,it.comments)
                }
            }
        }


    }
}

class PublicPostsViewModelFactory(private val postsRepo: PublicPostsRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PublicPostsViewModel::class.java)) {
            return PublicPostsViewModel(postsRepo) as T
        }
        throw IllegalStateException()
    }

}

@Composable
public fun BackHandler(enabled: Boolean = true, onBack: () -> Unit) {
    // Safely update the current `onBack` lambda when a new one is provided
    val currentOnBack by rememberUpdatedState(onBack)
    // Remember in Composition a back callback that calls the `onBack` lambda
    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                currentOnBack()
            }
        }
    }
    // On every successful composition, update the callback with the `enabled` value
    SideEffect {
        backCallback.isEnabled = enabled
    }
    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner"
    }.onBackPressedDispatcher
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, backDispatcher) {
        // Add callback to the backDispatcher
        backDispatcher.addCallback(lifecycleOwner, backCallback)
        // When the effect leaves the Composition, remove the callback
        onDispose {
            backCallback.remove()
        }
    }
}

@Composable
fun AppBar3(navController: NavController){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("home", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        IconButton(onClick = {
            navController.navigate(Screens.Notification.route)
        }){
            Icon(Icons.Default.Notifications, contentDescription = "notifications")
        }
        IconButton(onClick = {
            navController.navigate(Screens.Search.route)
        }){
            Icon(Icons.Outlined.Search,contentDescription = "search")
        }
    }
}

@Composable
fun PostComponent(name:String,content:String,imgUrl:String,likes:Long,comments:Long){

    var expanded by remember { mutableStateOf(false) }

    CoSoTheme {
        Column{
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50))){
                    // Profile Picture
                    AsyncImage(model = imgUrl,
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column(modifier = Modifier.weight(1f)) {
                    // Profile Name
                    Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            // Post Content
            Text(content, fontSize = 17.sp, lineHeight = 26.sp)

            Row{
                // Likes
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {}){
                        Icon(painterResource(R.drawable.heart), contentDescription = "likes")
                    }
                    Text(likes.toString())
                }
                Spacer(modifier = Modifier.height(10.dp))
                // Comments
                Row(verticalAlignment = Alignment.CenterVertically){
                    IconButton(onClick = {}){
                        Icon(painterResource(R.drawable.comments),contentDescription = "comments")
                    }
                    Text(comments.toString())
                }
            }
        }
    }
}


