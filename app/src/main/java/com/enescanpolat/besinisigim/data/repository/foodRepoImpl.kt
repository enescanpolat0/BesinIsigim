package com.enescanpolat.besinisigim.data.repository

import com.enescanpolat.besinisigim.data.dto.food_detail_dto.foodDetailDto
import com.enescanpolat.besinisigim.data.dto.foods_dto.foodsDto
import com.enescanpolat.besinisigim.data.remote.foodAPI
import com.enescanpolat.besinisigim.domain.repository.foodRepo
import javax.inject.Inject

class foodRepoImpl @Inject constructor(private val api: foodAPI):foodRepo {
    override suspend fun getFood(search: String): foodsDto {
        return api.searchFood(query = search)
    }

    override suspend fun getFoodDetail(fdcId: Int): foodDetailDto {
        return api.foodDetail(fdcId = fdcId)
    }
}