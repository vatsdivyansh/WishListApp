// AppBar.kt is the new UI composable file that I created
package com.example.wishlistapp



import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon

import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp


@Composable
//
// AppBarView is the function/ composable that i will use in the topBar composable
fun AppBarView(
    title : String , // title that the AppBar or TopBar is going to have
    onBackNavClicked: () -> Unit = {}
){
//    val navigationIcon: (@Composable () -> Unit)? = {
//        // but why we're using nullable here i.e "?" because we want sometime that navigationIcon should not appear (when we,re at different screen) that time we want navigationIcaon composable to be null
////        if(title.contains("WishList")){
//
//                IconButton(onClick = { onBackNavClicked() }) {
//                    Icon(
//                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                        tint = Color.White,
//                        contentDescription = null
//                    )
//
//            }
//
//
////        else {
////            null
////        }
//
//    }
//
//   TopAppBar(title = { Text(text = title ,
//       color = colorResource(id = R.color.white),
//       modifier = Modifier
//           .padding(start = 4.dp)
//           .heightIn(max = 24.dp) )
//                     },
//                            elevation = 3.dp, // elevation that we're adding to the app bar
//                            backgroundColor = colorResource(id = R.color.app_bar_color), // app_bar_color is the color that I'm going to create by myself go to values->color.xml
////                            navigationIcon =
////                             navigationIcon is a composable so we can can create another conposable and then van pass it here
//                            navigationIcon =if(title.contains("WishList")) navigationIcon else null
//
//       )
    val navigationIcon: (@Composable () -> Unit)? = {
        IconButton(onClick = { onBackNavClicked() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = Color.White,
                contentDescription = null
            )
        }
    }

    TopAppBar(
        title = {
            Text(
                text = title,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
        navigationIcon = if (!title.contains("WishList")) navigationIcon else null
    )



}