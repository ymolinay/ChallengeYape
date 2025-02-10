package com.yape.challengeyape.navigation

sealed class NavGraph(val route: String) {
    object MainScreen : NavGraph("main_screen")
    object DetailScreen : NavGraph("detail_screen/{itemId}") {
        fun createRoute(itemId: Int) = "detail_screen/$itemId"
    }
}