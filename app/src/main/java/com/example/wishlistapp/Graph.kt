package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository
// singleton --> a design pattern that ensures that a class has only one instance and provides global access to that instance.
//Graph Object: Represents a shared object graph in Dependency Injection (DI) frameworks like Dagger or Hilt. It maintains dependencies across the app's lifecycle and ensures that certain objects (like singletons) are shared efficiently.
object Graph {
    // single instance logic
    lateinit var database :WishDatabase
    val wishRepository by lazy {
        // by lazy makes sure that  this vairiable will be initialized once it is going to be needed --> the main idea behind this is that we don't load everything at the start when the when we opens up our application
        WishRepository(wishDao = database.wishDao())
    }
    fun provide(context: Context){
        database = Room.databaseBuilder(context , WishDatabase :: class.java ,"wishlist.db").build()

    }
}