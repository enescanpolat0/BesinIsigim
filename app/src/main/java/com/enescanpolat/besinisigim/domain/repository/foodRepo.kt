package com.enescanpolat.besinisigim.domain.repository

import com.enescanpolat.besinisigim.data.dto.food_detail_dto.foodDetailDto
import com.enescanpolat.besinisigim.data.dto.foods_dto.foodsDto

interface foodRepo {

    suspend fun getFood(search:String):foodsDto

    suspend fun getFoodDetail(fdcId:Int):foodDetailDto

}