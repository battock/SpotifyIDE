package com.example.spotifyide.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.spotifyide.Screen
import com.example.spotifyide.ui.theme.SpotifyIDETheme
import com.example.spotifyide.viewmodels.OtherScreenViewModel
import com.example.spotifyide.viewmodels.SharedViewModel

@Composable
fun OtherScreen(
    navController: NavController? = null,
    sharedViewModel: SharedViewModel? = null,
    otherScreenViewModel: OtherScreenViewModel = hiltViewModel()
) {
    Column {

        Text(text = "${otherScreenViewModel.title} ${sharedViewModel?.number?:0}")
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    sharedViewModel?.incrementNumber()
                    navController?.navigate(Screen.MainScreen.route) }) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(8.dp)
                ) {
                    Text(text = "main screen")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultOtherScreenPreview() {
    SpotifyIDETheme {
        OtherScreen()
    }
}