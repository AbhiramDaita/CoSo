package com.the.coso

sealed class BottomNavigationScreens(val route:String, val resourceId:Int){

    object Home : BottomNavigationScreens("HomeScreen",R.drawable.home_line)

    object Profile : BottomNavigationScreens("ProfileScreen",R.drawable.profile_thin)

    object Podcast : BottomNavigationScreens("PodcastScreen",R.drawable.ep_mic)

    object Explore : BottomNavigationScreens("ExploreScreen",R.drawable.explore_outline)

    object ClassRoom : BottomNavigationScreens("ClassRoomScreens",R.drawable.black_board_line)

}