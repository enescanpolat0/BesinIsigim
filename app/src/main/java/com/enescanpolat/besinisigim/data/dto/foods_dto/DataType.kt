package com.enescanpolat.besinisigim.data.dto.foods_dto

import com.google.gson.annotations.SerializedName

data class DataType(
    @SerializedName("Branded")
    val branded: Long,
    @SerializedName("Survey (FNDDS)")
    val surveyFndds: Long,
    @SerializedName("SR Legacy")
    val srLegacy: Long,
    @SerializedName("Foundation")
    val foundation: Long,
)