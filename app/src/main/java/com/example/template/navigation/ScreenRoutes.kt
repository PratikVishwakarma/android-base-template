package com.example.template.navigation

import kotlinx.serialization.Serializable

sealed interface ScreenRoutes {

    @Serializable
    data object UserScreen : ScreenRoutes
}