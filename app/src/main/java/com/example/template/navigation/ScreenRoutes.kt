package com.example.template.navigation

import kotlinx.serialization.Serializable

sealed interface ScreenRoutes {

    @Serializable
    data object SplashRoute : ScreenRoutes
    @Serializable
    data object UserRoute : ScreenRoutes
}