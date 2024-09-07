package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository

object Graph {
    lateinit var database :WishDatabase
    val wishRepository by lazy {
        // by lazy makes sure that  this vairiable will be initialized once it is going to be needed --> the main idea behind this is that we don't load everything at the start when the when we opens up our application
        WishRepository(wishDao = database.wishDao())
    }
    fun provide(context: Context){
        database = Room.databaseBuilder(context , WishDatabase :: class.java ,"wishlist.db").build()

    }
}