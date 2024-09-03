package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// and make this Dao class as an abstract class --> an abstract class is a class that don't need an implementation
@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    // we're saying that addWish is the function that will take care of adding something(a wish in our case here) into the database
    // onConflict --> if one try to add same wish then in that ignore the conflict and simply add that
    abstract suspend fun addAWish(wishEntity: Wish) // it don't need {} or content beacause it is a abstract --> we're saying that whoever wants to call addWish method needs to actually do the  implementation

    @Query("Select * from `wish-table`") // Loads all wishes from the wish-table --> Select *(asterick means all) fromt the wish-table i.e select all wishes from the wish-table
    abstract fun getAllWishes(): Flow<List<Wish>> // this method returns the list of all wishes // Flow is a asynchronous and cols stream of data that can emit multiple values over time. It's a part of Kotlin coroutines library and is used to handle sequences of data in a non blocking way . It works well with room to fetch and emit updates during data manipulation

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Long): Flow<Wish>


 // also make methods addWish, updateWish , deleteWish as suspend beacuse they will be running in background , but don't need to make getAllWishes and getAWishById as suspend because there we already used flow which is from coroutines library


}