package com.example.wishlistapp
// this class will going to have routes for different screens
// sealed classes --> no subclass can inherit from them
// ensures that all subclassed are defined in the same file, which makes route managment more predictable
sealed class Screen( val route: String) {
    object HomeScreen: Screen("home_screen")
    object AddScreen: Screen("add_screen")


}