package com.example.e_ramo_task.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.e_ramo_task.screens.FirstScreen
import com.example.e_ramo_task.screens.PaletteViewModel
import com.example.e_ramo_task.screens.SecondScreen

@Composable
fun ScreenHost(
    navHostController: NavHostController,
) {
    NavHost(navController = navHostController, startDestination = Screens.FirstScreen.route) {
        composable(Screens.FirstScreen.route) {
            FirstScreen(navHostController)
        }

        composable(Screens.SecondScreen.route, arguments = listOf(navArgument("imageUrl") {
            type = NavType.StringType
        })) { navBackStackEntry ->
            val imageUrl = navBackStackEntry.arguments?.getString("imageUrl") ?: ""
            SecondScreen(imageUrl,  viewModel(),navHostController)
        }
    }
}