// AppBar.kt is the new UI composable file that I created
package com.example.wishlistapp


import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp


@Composable
//
// AppBarView is the function/ composable that i will use in the topBar composable
fun AppBarView(
    title : String , // title that the AppBar or TopBar is going to have
    onBackNavClicked: () -> Unit = {}
){
   TopAppBar(title = { Text(text = title ,
       color = colorResource(id = R.color.white),
       modifier = Modifier
           .padding(start = 4.dp)
           .heightIn(max = 24.dp) )
                     },
                            elevation = 3.dp, // elevation that we're adding to the app bar
                            backgroundColor = colorResource(id = R.color.app_bar_color), // app_bar_color is the color that I'm going to create by myself go to values->color.xml
//                            navigationIcon =


       )

    


}