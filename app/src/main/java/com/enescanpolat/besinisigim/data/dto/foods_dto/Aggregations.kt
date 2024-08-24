package com.enescanpolat.besinisigim.data.dto.foods_dto

data class Aggregations(
    val dataType: DataType,
    val nutrients: Map<String,Any>
)