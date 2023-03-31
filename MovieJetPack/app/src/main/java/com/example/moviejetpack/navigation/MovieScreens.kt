package com.example.moviejetpack.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen,
    AboutScreen;

    companion object {
        fun fromRoute(route: String?) : MovieScreens = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            AboutScreen.name -> AboutScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not Recognised")
        }
    }
}