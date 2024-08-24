package com.enescanpolat.besinisigim.presentation.foodListView

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enescanpolat.besinisigim.domain.model.foodModel

@Composable
fun FoodListRow(foodmodel:foodModel,onItemClick : (foodModel)->Unit) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { (onItemClick(foodmodel)) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){


        Column(modifier = Modifier.align(CenterVertically),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(foodmodel.foodSearchQuery,
                style = MaterialTheme.typography.headlineLarge,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Text(foodmodel.foodDescription,
                style = MaterialTheme.typography.displayLarge,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Center
            )

        }

    }


}

