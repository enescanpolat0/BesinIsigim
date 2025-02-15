package com.enescanpolat.besinisigim.data.dto.foods_dto

data class Food(
    val additionalDescriptions: String,
    val allHighlightFields: String,
    val brandName: String,
    val brandOwner: String,
    val commonNames: String,
    val dataSource: String,
    val dataType: String,
    val description: String,
    val fdcId: Int,
    val finalFoodInputFoods: List<FinalFoodInputFood>,
    val foodAttributeTypes: List<FoodAttributeType>,
    val foodAttributes: List<FoodAttributeX>,
    val foodCategory: String,
    val foodCategoryId: Int,
    val foodCode: Int,
    val foodMeasures: List<FoodMeasure>,
    val foodNutrients: List<FoodNutrient>,
    val foodVersionIds: List<Any>,
    val gtinUpc: String,
    val householdServingFullText: String,
    val ingredients: String,
    val marketCountry: String,
    val microbes: List<Any>,
    val modifiedDate: String,
    val mostRecentAcquisitionDate: String,
    val ndbNumber: Int,
    val packageWeight: String,
    val publishedDate: String,
    val score: Double,
    val servingSize: Int,
    val servingSizeUnit: String,
    val shortDescription: String,
    val subbrandName: String,
    val tradeChannels: List<String>
)