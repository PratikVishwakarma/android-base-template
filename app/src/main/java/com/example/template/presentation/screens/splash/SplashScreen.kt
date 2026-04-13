package com.example.template.presentation.screens.splash

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.template.navigation.ScreenRoutes
import com.example.template.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel
) {

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(ScreenRoutes.UserRoute)
    }

    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
        Text(text = stringResource(R.string.app_name))
    }
}