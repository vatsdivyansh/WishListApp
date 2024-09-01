package com.example.wishlistapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// home view is going to be one which holds our scaffold and allows us to have a certain structure for our application
@Composable
fun HomeView(){
    // in jetpack compose scaffold is a layout structure that  provides a basic visual structure for our app , common UI elements --> top bar , bottonm bar , floating action button and a drawer
    // scaffold is ideal for creating standard app layout with a consistent structure , ensuring that all elements are corectly placed and behave s expected with minimun setup
    Scaffold(
        topBar ={ AppBarView(title = "WishList") } // content for  topbar is surrounded by curly braces because topBar need a composable
            // top bar is a composable so I can pass a whole composable in the top bar i.e I can create a new file and then pass a whole composable into the top bar i.e create a new file named AppBar and then proceed
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it) ){

        }

    }
}