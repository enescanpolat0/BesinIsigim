package com.enescanpolat.besinisigim.presentation.foodListView

import android.text.BoringLayout
import com.enescanpolat.besinisigim.domain.model.foodModel

data class foodListState(
    val isloading : Boolean=false,
    val foodlist : List<foodModel> = emptyList(),
    val error:String="",
    val search:String = "Cheddar Cheese"
)
