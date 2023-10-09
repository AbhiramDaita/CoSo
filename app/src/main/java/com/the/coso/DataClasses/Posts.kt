package com.the.coso.DataClasses

data class Posts(
    val id : String = "",
    val post : String ="",
    val likes : Long =0,
    val comments : Long =0,
    val date : String="",
    val userName : String="",
    val userProfile  : String="",
    val userID : String="",
)
