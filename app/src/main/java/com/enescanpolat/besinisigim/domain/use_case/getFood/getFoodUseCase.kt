package com.enescanpolat.besinisigim.domain.use_case.getFood

import com.enescanpolat.besinisigim.data.dto.foods_dto.tofoodModel
import com.enescanpolat.besinisigim.domain.model.foodModel
import com.enescanpolat.besinisigim.domain.repository.foodRepo
import com.enescanpolat.besinisigim.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class getFoodUseCase @Inject constructor(private val repo:foodRepo) {

    fun executeGetFood(search:String):Flow<Resource<List<foodModel>>> = flow{

        try {
            emit(Resource.Loading())
            val foodList = repo.getFood(search = search)
            emit(Resource.Success(foodList.tofoodModel()))

        }catch (e: IOError){
            emit(Resource.Error(e.localizedMessage ?: "Error!"))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Could not reach internet"))
        }


    }


}