package com.example.myapplication.navigation

sealed class Screens(val route: String) {
    object Home : Screens("Home")
    object Favourites : Screens("Favourites")
    object Info : Screens("Info/{key}")
}