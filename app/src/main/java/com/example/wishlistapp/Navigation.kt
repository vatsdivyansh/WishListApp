package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(viewModel: WishViewModel = viewModel() ,navController: NavHostController = rememberNavController()){
    NavHost(navController = navController , startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route){
            HomeView(navController , viewModel)
        }
        composable(Screen.AddScreen.route){
            AddEditDetailView(id = 0L, viewModel = viewModel, navController =navController )
            // so this now registers our new screen

        }
        // and we want to navigate to new screen when we click on FloationActionButton so now go to HomeView.kt

    }

}