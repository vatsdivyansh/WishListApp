package com.example.wishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [Wish::class] ,
    version = 1 ,
    exportSchema = false )
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}// now we want to use our WishDataBase and access it so that we can use WishDao which then gives us access to different methods defined in WishDao class