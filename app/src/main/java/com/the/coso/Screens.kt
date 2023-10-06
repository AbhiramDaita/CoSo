package com.the.coso

sealed class Screens(val route:String) {
    object Login : Screens(route = "LoginScreen")

    object Verification : Screens(route = "VerificationScreen")

    object GetStartedOne : Screens(route = "GetStartedOne")

    object GettingStartedTwo : Screens(route = "GettingStartedTwo/{userName}/{userCollege}")

    object GettingStartedThree : Screens(route = "GettingStartedThree")

    object OnBoarding : Screens(route ="onBoard")

    object Home : Screens(route = "HomeScreen")

    object Profile : Screens(route = "ProfileScreen")

    object Podcast : Screens("PodcastScreen")

    object Explore : Screens("ExploreScreen")

    object ClassRoom : Screens("ClassRoomScreens")

    object NewPostScreen : Screens("NewPostScreen")

    object Settings : Screens("SettingsScreen")

    object EditProfileScreen : Screens("EditProfileScreen")

    object HelpScreen : Screens("HelpScreen")

    object AboutScreen : Screens("AboutScreen")

    object AccountAbout : Screens("AccountAbout")

    object PrivacyScreen : Screens("PrivacyPolicy")

    object TermsUse : Screens("TermsOfUse")

}