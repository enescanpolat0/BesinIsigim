package com.enescanpolat.besinisigim.data.dto.foods_dto

data class FoodAttributeType(
    val description: String,
    val foodAttributes: List<FoodAttribute>,
    val id: Int,
    val name: String
)