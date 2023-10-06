package com.the.coso

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

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
            route = Screens.GettingStartedTwo.route,
            arguments = listOf(navArgument("userName") {type = NavType.StringType},
                navArgument("userCollege"){type = NavType.StringType}
            )
        ){ backstack->
            val name = backstack.arguments!!.getString("userName")
            val college = backstack.arguments!!.getString("userCollege")
            GettingStartedTwo(navController,name,college)
        }
        composable(route = Screens.GettingStartedThree.route){
            GettingStartedThree(navController)
        }
        composable(route = Screens.Login.route
        ){
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
        composable(route = Screens.NewPostScreen.route){
            NewPostScreen(navController)
        }
        composable(route = Screens.Settings.route){
            SettingsScreen(navController)
        }
        composable(route = Screens.EditProfileScreen.route){
            EditProfileScreen(navController)
        }
        composable(route = Screens.HelpScreen.route){
            HelpScreen(navController)
        }
        composable(route = Screens.AboutScreen.route){
            AboutScreen(navController)
        }
        composable(route = Screens.AccountAbout.route){
            AccountAboutScreen(navController)
        }
        composable(route = Screens.PrivacyScreen.route){
            PrivacyPolicyScreen(navController)
        }
        composable(route = Screens.TermsUse.route){
            TermsScreen(navController)
        }
    }

}