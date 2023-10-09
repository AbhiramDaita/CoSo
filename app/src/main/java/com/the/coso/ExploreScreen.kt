package com.the.coso

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var clicked by remember { mutableIntStateOf(0) }

    CoSoTheme {
        val rows = 3
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White).
        padding( start = 15.dp, end = 15.dp)) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.PickVisualMedia(),
                    onResult = {uri->
                        println(uri)
                        if (uri != null) {
                            uri.lastPathSegment?.let {
                                listRef.child(it).putFile(uri).addOnCompleteListener {
                                    println("completed upload")
                                }
                            }
                        }
                    }
                )
                if(clicked == 1){
                    SideEffect {
                        singlePhotoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                        clicked = 0
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("the art gallery", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))

                    Text("add photos", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.clickable {
                       clicked = 1
                    })

                }
                Spacer(modifier = Modifier.height(20.dp))
                listRef.listAll()
                    .addOnSuccessListener { (items,prefixes)->
                        list = items
                    }

                FlowRow(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    maxItemsInEachRow = rows
                ){
                    list
                        .forEach { item ->
                            var uri by remember{ mutableStateOf(Uri.parse("")) }
                            item.downloadUrl.addOnSuccessListener {
                                uri = it
                            }
                            AsyncImage(
                                model = uri,
                                contentDescription = "",
                                modifier = Modifier.height(190.dp).width(110.dp),
                                contentScale = ContentScale.Crop,
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