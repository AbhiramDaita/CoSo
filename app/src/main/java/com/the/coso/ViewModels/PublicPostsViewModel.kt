package com.the.coso.ViewModels

import androidx.lifecycle.ViewModel

class PublicPostsViewModel(val PublicPostsRepo : PublicPostsRepo) : ViewModel(){
    fun getPublicPostsInfo() = PublicPostsRepo.getPublicPosts()
}