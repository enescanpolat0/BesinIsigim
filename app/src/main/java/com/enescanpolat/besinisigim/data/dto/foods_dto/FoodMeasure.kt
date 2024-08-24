package com.enescanpolat.besinisigim.data.dto.foods_dto

data class FoodMeasure(
    val disseminationText: String,
    val gramWeight: Double,
    val id: Int,
    val measureUnitAbbreviation: String,
    val measureUnitId: Int,
    val measureUnitName: String,
    val modifier: String,
    val rank: Int
)