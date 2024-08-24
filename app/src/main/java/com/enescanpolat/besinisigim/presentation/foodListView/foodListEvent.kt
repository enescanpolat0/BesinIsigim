package com.enescanpolat.besinisigim.presentation.foodListView

sealed class foodListEvent {
    data class Search(val searchString:String):foodListEvent()
}