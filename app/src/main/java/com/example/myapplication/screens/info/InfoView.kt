package com.example.myapplication.screens.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.screens.BottomNavigationComponent

@Composable
fun InfoView(viewModel: InfoViewModel, navController: NavController) {
    val item by viewModel.item.observeAsState()
    Scaffold(bottomBar = {
        BottomNavigationComponent(navController = navController)
    }) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(it)
                .padding(10.dp)
        ) {
            IconButton(onClick = {
                viewModel.onClick()
                viewModel.updateItem()
            }) {
                if (item!!.liked) Icon(Icons.Default.Favorite, contentDescription = null)
                else Icon(Icons.Default.FavoriteBorder, contentDescription = null)
            }
            Text(item!!.name, fontSize = 20.sp)
            Text(item!!.author, fontSize = 15.sp)
            Text("${item!!.price} сум", fontSize = 16.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Icon",
                    tint = Color.Yellow
                )
                Text(item!!.rank.toString(), fontSize = 16.sp)
            }
            Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 10.dp))
            Text(item!!.description, fontSize = 16.sp)
        }
    }
}