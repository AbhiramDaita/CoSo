package com.the.coso.ViewModels


import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow

class PublicPostsRepo {
    private val firestore = FirebaseFirestore.getInstance()

    fun getPublicPosts() = callbackFlow {
        val collection = firestore.collection("posts")
        val snapshotListener = collection.addSnapshotListener { value, error ->
                 trySendBlocking(value)
                .onFailure {

                }
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}