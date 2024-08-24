package com.enescanpolat.besinisigim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enescanpolat.besinisigim.presentation.foodDetailView.FoodDetailScreen
import com.enescanpolat.besinisigim.presentation.foodListView.FoodScreen
import com.enescanpolat.besinisigim.presentation.ui.theme.BesinIsigimTheme
import com.enescanpolat.besinisigim.util.CONSTANTS.FDCID
import com.enescanpolat.besinisigim.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BesinIsigimTheme {
               Surface(color = MaterialTheme.colorScheme.background) {

                   val navController = rememberNavController()
                   
                   NavHost(navController = navController,
                       startDestination = Screen.FoodListScreen.route
                   ){
                       composable(route = Screen.FoodListScreen.route){
                           FoodScreen(navController = navController)
                       }
                       composable(route = Screen.FoodDetailScreen.route+"/{${FDCID}}"){
                           FoodDetailScreen()
                       }
                   }

               }
            }
        }
    }
}

