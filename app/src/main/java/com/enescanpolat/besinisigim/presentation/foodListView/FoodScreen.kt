package com.enescanpolat.besinisigim.presentation.foodListView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.enescanpolat.besinisigim.domain.model.foodModel
import com.enescanpolat.besinisigim.util.Screen

@Composable
fun FoodScreen(
    navController: NavController,
    viewModel : foodListViewModel = hiltViewModel()) {


    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {

        Column {
            FoodSearchBar(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                hint = "SEARCH",
                onTranslate = {
                    viewModel.onEvent(event = foodListEvent.Search(it))
                  }
            )

            LazyColumn (modifier = Modifier.fillMaxSize()){

                items(state.foodlist){foodlist->
                    FoodListRow(foodmodel = foodlist, onItemClick = {
                        //navigate food details
                        navController.navigate(Screen.FoodDetailScreen.route+"/${foodlist.fdcId}")
                    })
                }

            }
        }

    }


}


@Composable
fun FoodSearchBar(
    modifier: Modifier,
    hint: String = "",
    onTranslate: (String) -> Unit = {}
) {

    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier){

        TextField(value = text,
            keyboardActions = KeyboardActions(onDone = {onTranslate(text)}),
            onValueChange = {text = it},
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                }

        )

        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }


    }



}