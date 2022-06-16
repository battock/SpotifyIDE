package com.example.spotifyide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotifyide.ui.screens.MainScreen
import com.example.spotifyide.ui.screens.OtherScreen
import com.example.spotifyide.ui.theme.SpotifyIDETheme
import com.example.spotifyide.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavigationSystem()
        }
    }
}

@Composable
fun NavigationSystem(){
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = "mainScreen"
    ) {
        composable("mainScreen", arguments = listOf())
        { MainScreen(navController, sharedViewModel) }
        composable("otherScreen")
        { OtherScreen(navController, sharedViewModel) }
    }
}

sealed class Screen(val route: String) {
    object MainScreen : Screen("mainScreen")
    object OtherScreen : Screen("otherScreen")
}

