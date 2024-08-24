package com.enescanpolat.besinisigim.presentation.foodDetailView

import com.enescanpolat.besinisigim.domain.model.foodDetailModel

data class foodDetailState(
    val isloading : Boolean =true,
    val foodDetail : foodDetailModel?=null,
    val error:String=""
)