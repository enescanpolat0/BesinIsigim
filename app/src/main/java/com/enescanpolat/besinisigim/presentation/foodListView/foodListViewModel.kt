package com.enescanpolat.besinisigim.presentation.foodListView

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.besinisigim.domain.use_case.getFood.getFoodUseCase
import com.enescanpolat.besinisigim.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class foodListViewModel @Inject constructor(
    private val getFoodUseCase: getFoodUseCase
):ViewModel() {


    private val _state = mutableStateOf<foodListState>(foodListState())
    val state : State<foodListState> = _state


    private var job : Job?=null

    init {
        getFoods(_state.value.search)
    }

    fun getFoods(search:String){
        job?.cancel()

        job = getFoodUseCase.executeGetFood(search = search).onEach {

            when(it){
                is Resource.Success->{
                    _state.value= foodListState(foodlist = it.data?: emptyList())
                }
                is Resource.Loading->{
                    _state.value= foodListState(isloading = true)
                }
                is Resource.Error->{
                    _state.value= foodListState(error = "ERROR")
                }

            }



        }.launchIn(viewModelScope)

    }

    fun onEvent(event: foodListEvent){
        when(event){
            is foodListEvent.Search->{
                getFoods(event.searchString)
            }
        }
    }



}