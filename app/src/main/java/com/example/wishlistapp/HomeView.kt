package com.example.wishlistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish
import androidx.compose.foundation.lazy.items


// home view is going to be one which holds our scaffold and allows us to have a certain structure for our application
@Composable
fun HomeView(){
    // in jetpack compose scaffold is a layout structure that  provides a basic visual structure for our app , common UI elements --> top bar , bottonm bar , floating action button and a drawer
    // scaffold is ideal for creating standard app layout with a consistent structure , ensuring that all elements are corectly placed and behave s expected with minimun setup
    Scaffold(
        topBar ={ AppBarView(title = "WishList") }, // content for  topbar is surrounded by curly braces because topBar need a composable
            // top bar is a composable so I can pass a whole composable in the top bar i.e I can create a new file and then pass a whole composable into the top bar i.e create a new file named AppBar and then proceed
        floatingActionButton = {
            // floatingActionButton --> FAB is a circular button that floats above the UI , typically used for screen's primary action , like adding an item
            // Purpose of FAB : Trigger key actions, Visual : Circular, elevated with a Icon inside
            //  onClick = { /* add navigation to add screen here */ }
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp) ,
                contentColor = Color.Black ,
                backgroundColor = Color.Gray ,
                onClick = { /* add navigation to add screen here */ } ,
                ) {
                    Icon(imageVector = Icons.Default.Add , contentDescription = null  )

            }
        }
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it) ){
            items(DummyWish.wishList){
                // for my/user every wish create a WishItem
                wish -> WishItem(wish = wish , onClick = {})
            }

        }

    }
}

// how a wish item should look like
@Composable
fun WishItem(wish:Wish , onClick: ()->Unit){
    androidx.compose.material.Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        } ,// I want to make that clickable show that I can see further description . and execute the onClick() method when I click that
            elevation = 10.dp ,
        backgroundColor = Color.White
        ) {
        // a card in jetpack compose is a container with elevation and rounded corners , used to prevent content in a visually distinct manner .Common Uses->Show summaries along with the title which describes it even more ,  highlight key information with images and text ,provide clickable and toucable responsive areas
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title , fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)

        }
    }

}