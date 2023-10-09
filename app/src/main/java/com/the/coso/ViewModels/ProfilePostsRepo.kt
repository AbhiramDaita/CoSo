package com.the.coso.ViewModels

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow

class ProfilePostsRepo {

    private val firestore = FirebaseFirestore.getInstance()

    fun getProfilePosts(uid:String) = callbackFlow {
        val collection = firestore.collection("users")
            .document(uid)
            .collection("posts")

        val snapshotlistener = collection.addSnapshotListener{value,error->
            trySendBlocking(value)
                .onFailure {

                }
        }
        awaitClose {
            snapshotlistener.remove()
        }
    }


}