package com.example.wishlistapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel

class WishViewModel: ViewModel() {
   var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")
    fun onWishTitleChanged(newString: String) {
        wishTitleState =
            newString  // we're saying that hey viewModel just enable us to use wishTitleState(which is mutable state) whenever we're changing the wishTitle and do the same with our wishDescriptionState
    }
        fun onWishDescriptionChanged(newString: String){
            wishDescriptionState = newString
        }
}