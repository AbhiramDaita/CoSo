package com.the.coso

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.the.coso.ui.theme.CoSoTheme
import com.google.firebase.storage.ktx.component1
import com.google.firebase.storage.ktx.component2


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExploreScreen(navController: NavController){

    val storage = Firebase.storage
    val listRef = storage.reference.child("/ArtGallery")
    var list : List<StorageReference> by rememberSaveable { mutableStateOf(listOf()) }

    CoSoTheme {
        val rows = 3
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White).
        padding(bottom = 0.dp, top = 15.dp, start = 15.dp, end = 15.dp)) {
            item {
                AppBar("the art gallery",navController)
                Spacer(modifier = Modifier.height(20.dp))

                listRef.listAll()
                    .addOnSuccessListener { (items,prefixes)->
                        list = items
                    }

                FlowRow(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    maxItemsInEachRow = rows
                ){
                    list
                        .forEach { item ->
                            var uri : Uri = Uri.parse("")
                            item.downloadUrl.addOnSuccessListener {
                                uri = it
                            }
                            AsyncImage(
                                model = uri,
                                contentDescription = ""
                            )
                        }
                }
            }
        }
    }
}

@Preview
@Composable
fun PrevExplore(){
    ExploreScreen(rememberNavController())
}