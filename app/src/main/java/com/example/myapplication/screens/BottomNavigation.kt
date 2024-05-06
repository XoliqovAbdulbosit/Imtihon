package com.example.myapplication.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
fun BottomNavigationComponent(navController: NavController) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = "Favourites",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
        ),
    )
    val currentRoute = navController.currentDestination?.route
    NavigationBar(containerColor = Color.White) {
        items.forEachIndexed { _, item ->
            NavigationBarItem(selected = currentRoute == item.title, onClick = {
                navController.navigate(item.title)
            }, label = {
                Text(item.title)
            }, icon = {
                Icon(
                    imageVector = if (currentRoute == item.title) {
                        item.selectedIcon
                    } else item.unselectedIcon,
                    contentDescription = item.title,
                    tint = Color.Black,
                )
            }, colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Gray))
        }
    }
}