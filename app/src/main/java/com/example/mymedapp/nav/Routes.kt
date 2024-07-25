package com.example.mymedapp.nav

import kotlinx.serialization.Serializable

sealed class Routes {
     @Serializable
     object  welcome
    @Serializable
    object  signin
    @Serializable
    object  signup
    @Serializable
    object  Homescreen
}
