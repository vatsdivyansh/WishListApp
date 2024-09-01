package com.example.wishlistapp.data

// this data class takes care how a wish should look like i.e how many and what type of properties it should have

data class Wish(
    val id: Long = 0L ,
    val title : String = "" ,
    val description: String = ""
)
object  DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch Pixel 2" , description = "An Android watch") ,
        Wish(title = "Oculus Quest 2" , description = "A VR headset for playing games ") ,
        Wish(title = "A sci-fi book" , description = "A book based on science and nature ") ,
        Wish(title = "Bean Bag" , description = "A comfy bean bag to substitute a chair ")
    )
}
