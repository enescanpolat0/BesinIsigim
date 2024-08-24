package com.enescanpolat.besinisigim.presentation.foodDetailView

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enescanpolat.besinisigim.domain.use_case.getFoodDetail.getFoodDetailUseCase
import com.enescanpolat.besinisigim.util.CONSTANTS.FDCID
import com.enescanpolat.besinisigim.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class foodDetailViewModel @Inject constructor(
    private val getfoodDetailUseCase: getFoodDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) :ViewModel() {

    private val _state = mutableStateOf<foodDetailState>(foodDetailState())
    val state : State<foodDetailState> = _state

    init {
        savedStateHandle.get<String>(FDCID.toString())?.toIntOrNull()?.let {
            getFoodDetail(fdcId = it)
        }
    }

    private fun getFoodDetail(fdcId:Int){
        getfoodDetailUseCase.executeGetFoodDetail(fdcId=fdcId).onEach {
            when(it){
                is Resource.Success->{
                    _state.value=foodDetailState(foodDetail = it.data)
                }
                is Resource.Loading->{
                    _state.value=foodDetailState(isloading = true)
                }
                is Resource.Error->{
                    _state.value=foodDetailState(error = "ERROR")
                }
            }
        }.launchIn(viewModelScope)
    }

}