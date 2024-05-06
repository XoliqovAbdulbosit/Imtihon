package com.example.myapplication.screens.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.database.Item

class FavouritesViewModel(val model: FavouritesModel) {
    private var _items = MutableLiveData(mutableListOf<Item>())
    val items: LiveData<MutableList<Item>> = _items

    init {
        getItems()
    }

    private fun getItems() {
        _items.value = model.getLikedItems()
    }
}