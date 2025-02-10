package com.yape.challengeyape.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yape.challengeyape.navigation.NavGraph
import com.yape.challengeyape.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = viewModel()) {
    val data by viewModel.data.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { viewModel.fetchData() }) {
            Text("Load Data")
        }

        LazyColumn {
            items(data) { item ->
                Text(
                    text = item.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navController.navigate(NavGraph.DetailScreen.createRoute(item.id)) }
                )
            }
        }
    }
}