package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.screens.favourites.FavouritesModel
import com.example.myapplication.screens.favourites.FavouritesView
import com.example.myapplication.screens.favourites.FavouritesViewModel
import com.example.myapplication.screens.home.HomeModel
import com.example.myapplication.screens.home.HomeView
import com.example.myapplication.screens.home.HomeViewModel
import com.example.myapplication.screens.info.InfoModel
import com.example.myapplication.screens.info.InfoView
import com.example.myapplication.screens.info.InfoViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(
        navController = navController, startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            val model = HomeModel(context)
            val viewModel = HomeViewModel(model)
            HomeView(viewModel, navController)
        }
        composable(route = Screens.Favourites.route) {
            val model = FavouritesModel(context)
            val viewModel = FavouritesViewModel(model)
            FavouritesView(viewModel, navController)
        }
        composable(
            route = Screens.Info.route, arguments = listOf(navArgument("key") {
                type = NavType.IntType
            })
        ) {
            val id = it.arguments?.getInt("key")!!
            val model = InfoModel(context)
            val viewModel = InfoViewModel(model, id)
            InfoView(viewModel, navController)
        }
    }
}