package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

// the repository class in room database acts as a intermediary between vieeModel and the data source(room, network).Itr manages data operations ,abstracts the data source and provides a clean API for accessing data , ensuring that the viewModel doesn't need to know the details of data handling

class WishRepository(private val wishDao:WishDao) {
    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }
    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()
    fun getAWishById(id:Long) :Flow<Wish> {return wishDao.getAWishById(id)}
    suspend fun updateAWish(wish: Wish){
        wishDao.updateAWish(wish)
    }
    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }
}