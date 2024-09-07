package com.example.wishlistapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository
): ViewModel() {

   var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")
    fun onWishTitleChanged(newString: String) {
        wishTitleState =
            newString  // we're saying that hey viewModel just enable us to use wishTitleState(which is mutable state) whenever we're changing the wishTitle and do the same with our wishDescriptionState
    }
        fun onWishDescriptionChanged(newString: String){
            wishDescriptionState = newString
        }
     lateinit var getAllWishes: Flow<List<Wish>> // we can use Flow to get a list of wishes , and lateinit is a modifier in Kotlin using which we make a promise to Kotlin compiler that the variable will be initialized before we call any operation on it.
     // or we can say that lateinit is used to create a variable in Kotlin that will be initialized later and it is usable only with var(mutable )properties and ant be used with immutable properties (val)
     // if we use lateinit with val it will give us a run time error as the variables declared using val need to be initialised at the time of declaration or in  the constructor .
     //We use lateinit with Flow<List<>> to initialize it later, such as in dependency injection scenarios or when data isn’t available at object creation.
     init {
         //
         viewModelScope.launch {
             // so now our getAllWishes will be initialized inside of this viewModel scope inside of this coroutineScope
             getAllWishes = wishRepository.getWishes()
         }
         // so now getAllWIshes will not be empty after this initializer
     }
    fun addWish(wish:Wish){
        viewModelScope.launch(Dispatchers.IO) {
            // Dispatchers define the thread or pool for coroutines
            // Dispatchers.IO --> for blocking IO tasks
            wishRepository.addAWish(wish = wish)
        }

    }
    fun getAWishById(id:Long):Flow<Wish> {

           return wishRepository.getAWishById(id)

    }
    fun updateWish(wish:Wish){
        viewModelScope.launch {
            wishRepository.updateAWish(wish = wish)
        }
    }
    fun deleteAWish(wish : Wish){
        viewModelScope.launch {
            wishRepository.deleteAWish(wish = wish )

        }
    }



}