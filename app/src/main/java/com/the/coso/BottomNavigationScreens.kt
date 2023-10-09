package com.the.coso

sealed class BottomNavigationScreens(val route:String, val resourceId:Int){

    object Home : BottomNavigationScreens(Screens.Home.route,R.drawable.home_line)

    object Profile : BottomNavigationScreens(Screens.Profile.route,R.drawable.profile_thin)

    object Podcast : BottomNavigationScreens(Screens.PodcastsList.route,R.drawable.ep_mic)

    object Explore : BottomNavigationScreens(Screens.Explore.route,R.drawable.explore_outline)

    object ClassRoom : BottomNavigationScreens(Screens.ClassRoom.route,R.drawable.black_board_line)

}