package com.example.myapplication.screens.info

import android.content.Context
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.database.Item

class InfoModel(context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun getItem(id: Int): Item {
        return localDB.getItemDAO().getData(id)
    }

    fun updateItem(item: Item) {
        localDB.getItemDAO().updateData(item)
    }
}