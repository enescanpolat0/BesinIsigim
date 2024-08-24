package com.enescanpolat.besinisigim.data.remote

import com.enescanpolat.besinisigim.data.dto.food_detail_dto.foodDetailDto
import com.enescanpolat.besinisigim.data.dto.foods_dto.foodsDto
import com.enescanpolat.besinisigim.util.CONSTANTS.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface foodAPI {

    @GET("fdc/v1/foods/search")
    suspend fun searchFood(
        @Query("api_key")apiKey:String=API_KEY,
        @Query("query")query:String
    ):foodsDto


    @GET("fdc/v1/food/{fdcId}")
    suspend fun foodDetail(
        @Path("fdcId") fdcId:Int,
        @Query("api_key") apiKey:String= API_KEY
    ):foodDetailDto


}