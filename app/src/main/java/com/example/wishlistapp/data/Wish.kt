package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// this data class takes care how a wish should look like i.e how many and what type of properties it should have
// take the data class that we want as the object type that we want to store permanently on our phone --> in our case it it the Wish data class
// setting up the @Entity for our data class
@Entity(tableName = "wish-table") // now we will create wishes and every single wish will bwcome a new row
// we can have 1 table or more than 1 table in our case we will going to have 1 table which is wish-table , no table means the database is empty
// and in that table we will going to have different Columns which will be the different properties of our data class and every new entry of our table will be a new row




data class Wish(
    @PrimaryKey(autoGenerate = true) // make the id as PrimaryKey, we cant make title or description as PrimaryKey because they can repeat
    val id: Long = 0L ,
    @ColumnInfo(name = "wish-title")
    val title : String = "" ,
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
) // see this class as --> whole google sheet is a database, name of the file is Table , and it contains three Columns one contains value of id , one contains wish-title and third one contains wish-desc(suppose we fill id with value 1 in row 1 , so when we move to row 2 id will by default start with 2 beacause we make id as PrimaryKey and also we set autoGenerate to true for the PrimaryKey i.e id
// now our data class is pretty much ready to be used in a DAO to be used to store data permanently
object  DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch Pixel 2" , description = "An Android watch") ,
        Wish(title = "Oculus Quest 2" , description = "A VR headset for playing games ") ,
        Wish(title = "A sci-fi book" , description = "A book based on science and nature ") ,
        Wish(title = "Bean Bag" , description = "A comfy bean bag to substitute a chair ")
    )
}
