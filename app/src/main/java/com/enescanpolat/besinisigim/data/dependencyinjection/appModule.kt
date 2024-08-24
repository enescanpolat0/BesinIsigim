package com.enescanpolat.besinisigim.data.dependencyinjection

import com.enescanpolat.besinisigim.data.remote.foodAPI
import com.enescanpolat.besinisigim.data.repository.foodRepoImpl
import com.enescanpolat.besinisigim.domain.repository.foodRepo
import com.enescanpolat.besinisigim.util.CONSTANTS.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {


    @Singleton
    @Provides
    fun injectFoodApi():foodAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(foodAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectFoodRepo(api: foodAPI):foodRepo{
        return foodRepoImpl(api=api)
    }

}