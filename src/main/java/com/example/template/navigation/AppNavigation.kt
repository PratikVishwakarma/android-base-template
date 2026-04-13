package com.example.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.template.presentation.screens.user.UserScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.template.presentation.screens.user.UserViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.UserScreen
    ) {

        composable<ScreenRoutes.UserScreen> {

            val viewModel: UserViewModel = hiltViewModel()

            UserScreen(viewModel = viewModel)
        }
    }
}