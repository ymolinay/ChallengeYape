package com.yape.challengeyape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yape.challengeyape.navigation.NavGraph
import com.yape.challengeyape.ui.DetailScreen
import com.yape.challengeyape.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = NavGraph.MainScreen.route) {
                composable(NavGraph.MainScreen.route) {
                    MainScreen(navController)
                }
                composable(NavGraph.DetailScreen.route) { backStackEntry ->
                    val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull() ?: 0
                    DetailScreen(navController, itemId)
                }
            }
        }
    }
}