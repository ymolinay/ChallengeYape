package com.yape.challengeyape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yape.challengeyape.navigation.NavGraph
import com.yape.challengeyape.ui.DetailScreen
import com.yape.challengeyape.ui.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = NavGraph.MainScreen.route) {
                composable(NavGraph.MainScreen.route) {
                    MainScreen(navController)
                }
                composable(
                    route = NavGraph.DetailScreen.route,
                    arguments = listOf(navArgument("itemId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
                    DetailScreen(navController, itemId)
                }
            }
        }
    }
}