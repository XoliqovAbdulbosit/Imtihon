package com.example.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    var liked: Boolean = false,
)