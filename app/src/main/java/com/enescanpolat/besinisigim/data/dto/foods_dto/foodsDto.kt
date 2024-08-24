package com.enescanpolat.besinisigim.data.dto.foods_dto

import com.enescanpolat.besinisigim.domain.model.foodModel

data class foodsDto(
    val aggregations: Aggregations,
    val currentPage: Int,
    val foodSearchCriteria: FoodSearchCriteria,
    val foods: List<Food>,
    val pageList: List<Int>,
    val totalHits: Int,
    val totalPages: Int
)

fun foodsDto.tofoodModel():List<foodModel>{
    val searchquery = foodSearchCriteria.query
    return foods.map {
        foodModel(fdcId = it.fdcId, foodDescription = it.description, foodSearchQuery = searchquery)
    }

}