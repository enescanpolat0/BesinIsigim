package com.enescanpolat.besinisigim.data.dto.foods_dto

data class FoodNutrient(
    val dataPoints: Int,
    val derivationCode: String,
    val derivationDescription: String,
    val derivationId: Int,
    val foodNutrientId: Int,
    val foodNutrientSourceCode: String,
    val foodNutrientSourceDescription: String,
    val foodNutrientSourceId: Int,
    val indentLevel: Int,
    val max: Double,
    val median: Double,
    val min: Double,
    val nutrientId: Int,
    val nutrientName: String,
    val nutrientNumber: String,
    val percentDailyValue: Float,
    val rank: Int,
    val unitName: String,
    val value: Double
)