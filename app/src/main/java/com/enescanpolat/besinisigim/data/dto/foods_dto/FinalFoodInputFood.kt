package com.enescanpolat.besinisigim.data.dto.foods_dto

data class FinalFoodInputFood(
    val foodDescription: String,
    val gramWeight: Float,
    val id: Int,
    val portionCode: String,
    val portionDescription: String,
    val rank: Int,
    val srCode: Int,
    val unit: String,
    val value: Float
)