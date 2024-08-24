package com.enescanpolat.besinisigim.domain.use_case.getFoodDetail

import com.enescanpolat.besinisigim.data.dto.food_detail_dto.tofoodDetailModel
import com.enescanpolat.besinisigim.domain.model.foodDetailModel
import com.enescanpolat.besinisigim.domain.repository.foodRepo
import com.enescanpolat.besinisigim.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class getFoodDetailUseCase @Inject constructor(private val repo: foodRepo) {


    fun executeGetFoodDetail(fdcId:Int):Flow<Resource<foodDetailModel>> = flow {

        try {

            emit(Resource.Loading())
            val foodDetail = repo.getFoodDetail(fdcId = fdcId).tofoodDetailModel()
            emit(Resource.Success(foodDetail))

        }catch (e: IOError){
            emit(Resource.Error(e.localizedMessage ?: "Error!"))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Could not reach internet"))
        }


    }

}