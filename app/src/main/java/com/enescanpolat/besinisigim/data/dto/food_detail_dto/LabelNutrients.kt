package com.enescanpolat.besinisigim.data.dto.food_detail_dto

data class LabelNutrients(
    val calories: Calories,
    val carbohydrates: Carbohydrates,
    val cholesterol: Cholesterol,
    val fat: Fat,
    val fiber: Fiber,
    val protein: Protein,
    val saturatedFat: SaturatedFat,
    val sodium: Sodium,
    val sugars: Sugars,
    val transFat: TransFat
)