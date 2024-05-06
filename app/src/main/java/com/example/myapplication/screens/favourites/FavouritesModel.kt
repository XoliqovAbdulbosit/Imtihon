package com.example.myapplication.screens.favourites

import android.content.Context
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.database.Item

class FavouritesModel(context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun getLikedItems(): MutableList<Item> {
        return localDB.getItemDAO().getLikedData()
    }
}