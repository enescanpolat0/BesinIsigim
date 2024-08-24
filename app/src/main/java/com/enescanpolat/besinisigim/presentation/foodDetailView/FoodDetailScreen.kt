package com.enescanpolat.besinisigim.presentation.foodDetailView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.enescanpolat.besinisigim.util.Screen

@Composable
fun FoodDetailScreen(foodDetailViewModel: foodDetailViewModel = hiltViewModel()) {

    val  state = foodDetailViewModel.state.value
    
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        state.foodDetail?.let {

            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){


                Text(text = it.Description,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(5.dp),
                    color = Color.White
                )
                Text(text = it.NutrientName,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(5.dp),
                    color = Color.White
                )

                Text(text = it.Protein.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(5.dp),
                    color = Color.White
                )

                Text(text = it.NutrientUnitName,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(5.dp),
                    color = Color.White
                )


                //

            }

        }

        if (state.error.isNotBlank()){
            Text(text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isloading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}