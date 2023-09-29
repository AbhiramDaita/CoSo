package com.the.coso

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController : NavHostController
){
    NavHost(navController = navController, startDestination = Screens.OnBoarding.route){
        composable(
            route = Screens.OnBoarding.route
        ){
            OnBoardingScreen(navController)
        }
        composable(
            route = Screens.GetStartedOne.route
        ){
            GetStartedOneScreen(navController)
        }
        composable(
            route = Screens.GettingStartedTwo.route
        ){
            GettingStartedTwo(navController)
        }
        composable(route = Screens.GettingStartedThree.route){
            GettingStartedThree(navController)
        }
        composable(route = Screens.Login.route){
            LoginScreen(navController)
        }
        composable(route=Screens.Verification.route){
            VerificationScreen(navController)
        }
        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.Explore.route){
            ExploreScreen(navController)
        }
        composable(route = Screens.Podcast.route){
            PodcastScreen(navController)
        }
        composable(route = Screens.ClassRoom.route){
            ClassRoomScreen(navController)
        }
        composable(route = Screens.Profile.route){
            ProfileScreen(navController)
        }
    }

}