package com.the.coso


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
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

import coil.compose.AsyncImage
import com.the.coso.ui.theme.CoSoTheme
import com.the.coso.ui.theme.Twelve



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
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            PostComponent()
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
                println(padding)
            }

        }
    }
}


@Composable
fun PostComponent(){
    var expanded by remember { mutableStateOf(false) }
    CoSoTheme {
        Column(modifier = Modifier.padding(10.dp).background(Color.White)){
            Row(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50))){
                    // Profile Picture
                    AsyncImage(
                        model="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsynwv-5qtogtOwJbIjaPFJUmHpzhxgqIAug&usqp=CAU",
                        contentDescription = "Profile Picture"
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column(modifier = Modifier.weight(1f)) {
                    // Profile Name
                    Text("not_marcus", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    // Single-Line Bio
                    Text("The go-to guy of CS", fontSize = 14.sp)
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            // Post Content
            Text("Hello Guys, I am the new student of CS. Hope we get together.", fontSize = 17.sp, lineHeight = 26.sp)

            Row(){
                // Likes
                IconButton(onClick = {}){

                }

                // Comments
                IconButton(onClick = {}){

                }
            }
        }
    }
}


@Preview
@Composable
fun prevHome(){
    PostComponent()
}