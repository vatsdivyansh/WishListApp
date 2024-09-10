package com.example.wishlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wishlistapp.ui.theme.WishListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WishListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    HomeView()
                    Navigation()
                }
            }
        }
    }
}
// basic flow when we want to use room database ->
// Step 1) create the data class in our case it is the "Wish Data Class"
// Step 2) create the DAO class(in our case it it WishDao class ) in which we define the CRUD operations i.e how they are going to work for our particular class (in our case Wish Data class )
// Step 3 ) once the Dao class is ready , create repository class (in our case it is WishRepository) --> in our case WishRepository class handles the CRUD operations





//Dependency injection --> DI provides an object's dependencies from outside , improving modularity , testability and flexibility


