package com.the.coso.ViewModels

import androidx.lifecycle.ViewModel

class ProfilePostsViewModel(val ProfilePosts : ProfilePostsRepo):ViewModel(){
    fun getProfilePosts(uid:String) = ProfilePosts.getProfilePosts(uid)
}
