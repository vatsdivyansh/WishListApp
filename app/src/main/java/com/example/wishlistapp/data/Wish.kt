package com.example.wishlistapp.data

// this data class takes care how a wish should look like i.e how many and what type of properties it should have

data class Wish(
    val id: Long = 0L ,
    val title : String = "" ,
    val description: String = ""
)
