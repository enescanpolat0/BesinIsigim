package com.enescanpolat.besinisigim.util

sealed class Screen (val route:String){
    object FoodListScreen : Screen(route = "food_screen")
    object FoodDetailScreen:Screen(route = "food_detail_screen")
}