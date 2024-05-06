package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDAO {
    @Insert
    fun insertData(item: Item)

    @Delete
    fun deleteData(item: Item)

    @Update
    fun updateData(item: Item)

    @Query("SELECT * FROM Items")
    fun getAllData(): MutableList<Item>

    @Query("SELECT * FROM Items WHERE id = :id")
    fun getData(id: Int): Item

    @Query("SELECT * FROM Items WHERE liked = 1")
    fun getLikedData(): MutableList<Item>
}