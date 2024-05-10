package com.example.myapplication.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.Item

class HomeViewModel(val model: HomeModel) : ViewModel() {
    private var _items = MutableLiveData(mutableListOf<Item>())
    val items: LiveData<MutableList<Item>> = _items

    val database = listOf(
        Item(name = "iPhone 15 Pro Max", description = "More than power"),
        Item(name = "Samsung S24 Ultra", description = "Bright Future"),
        Item(name = "Redmi Note 13 Pro Plus", description = "All In One"),
        Item(name = "Huawei Mate XS", description = "Your cool mate"),
    )

    init {
        if (model.isFirstRun()) addItems()
        getItems()
    }

    private fun getItems() {
        _items.value = model.getItems()
    }

    private fun addItems() {
        for (item in database) {
            model.addItem(item)
        }
    }
}