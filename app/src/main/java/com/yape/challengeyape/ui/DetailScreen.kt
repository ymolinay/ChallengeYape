package com.yape.challengeyape.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, itemId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detail Screen") })
        }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Text(text = "Item ID: $itemId", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}