package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun Navigation(viewModel: WishViewModel = viewModel() ,navController: NavHostController = rememberNavController()){
    NavHost(navController = navController , startDestination = Screen.HomeScreen.route){

    }

}