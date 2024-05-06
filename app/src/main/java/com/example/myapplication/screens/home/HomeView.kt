package com.example.myapplication.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.screens.BottomNavigationComponent

@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavController) {
    val items = viewModel.items.observeAsState().value
    Scaffold(bottomBar = {
        BottomNavigationComponent(navController = navController)
    }) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {
            items(items!!) { item ->
                Text(item.name,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clickable {
                            navController.navigate("Info/${item.id}")
                        })
            }
        }
    }
}