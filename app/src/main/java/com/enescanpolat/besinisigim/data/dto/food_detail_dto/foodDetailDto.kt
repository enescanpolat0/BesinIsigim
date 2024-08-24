package com.enescanpolat.besinisigim.data.dto.food_detail_dto

import com.enescanpolat.besinisigim.domain.model.foodDetailModel

data class foodDetailDto(
    val availableDate: String,
    val brandName: String,
    val brandOwner: String,
    val brandedFoodCategory: String,
    val dataSource: String,
    val dataType: String,
    val description: String,
    val discontinuedDate: String,
    val fdcId: Int,
    val foodAttributes: List<FoodAttribute>,
    val foodClass: String,
    val foodComponents: List<Any>,
    val foodNutrients: List<FoodNutrient>,
    val foodPortions: List<Any>,
    val foodUpdateLog: List<FoodUpdateLog>,
    val gtinUpc: String,
    val ingredients: String,
    val labelNutrients: LabelNutrients,
    val marketCountry: String,
    val modifiedDate: String,
    val packageWeight: String,
    val publicationDate: String,
    val servingSize: Int,
    val servingSizeUnit: String
)

fun foodDetailDto.tofoodDetailModel(): foodDetailModel {
    return foodDetailModel(
        Calories = labelNutrients.calories.value,
        Carbohydrates = labelNutrients.carbohydrates.value,
        Cholesterol = labelNutrients.cholesterol.value,
        Description = description,
        Fat = labelNutrients.fat.value,
        Fiber = labelNutrients.fiber.value,
        Protein = labelNutrients.protein.value,
        SaturatedFat = labelNutrients.saturatedFat.value,
        Sodium = labelNutrients.sodium.value,
        Sugars = labelNutrients.sugars.value,
        TransFat = labelNutrients.transFat.value,
        NutrientName = foodNutrients.map {
            it.nutrient.name
        }.toString(),
        NutrientUnitName = foodNutrients.map {
            it.nutrient.unitName
        }.toString(),
        NutrientAmount = foodNutrients.map {
            it.amount
        }
    )
}