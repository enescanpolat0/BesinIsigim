package com.enescanpolat.besinisigim.data.dto.food_detail_dto

data class FoodNutrient(
    val amount: Float,
    val foodNutrientDerivation: FoodNutrientDerivation,
    val id: Int,
    val nutrient: Nutrient,
    val type: String
)