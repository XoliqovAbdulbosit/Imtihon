package com.example.myapplication.screens.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.Item

class InfoViewModel(val model: InfoModel, val id: Int) : ViewModel() {
    private var _item = MutableLiveData(Item(name = "", description = ""))
    val item: LiveData<Item> = _item

    init {
        getItem()
    }

    fun getItem() {
        _item.value = model.getItem(id)
    }

    fun updateItem() {
        model.updateItem(_item.value!!)
    }

    fun onClick() {
        val currentItem = _item.value!!
        _item.value = currentItem.copy(liked = !currentItem.liked)
    }
}