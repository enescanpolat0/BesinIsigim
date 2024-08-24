package com.enescanpolat.besinisigim.domain.model


data class foodDetailModel(
    val Calories: Int,
    val Carbohydrates: Int,
    val Cholesterol: Float,
    val Description:String,
    val Fat: Int,
    val Fiber: Float,
    val Protein: Int,
    val SaturatedFat: Int,
    val Sodium: Int,
    val Sugars: Int,
    val TransFat: Int,
    val NutrientName:String,
    val NutrientUnitName:String,
    val NutrientAmount: List<Float>
)

