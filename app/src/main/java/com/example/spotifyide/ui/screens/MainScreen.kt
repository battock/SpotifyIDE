package com.example.spotifyide.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.squareup.moshi.JsonClass
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.spotifyide.Screen
import com.example.spotifyide.ui.theme.SpotifyIDETheme
import com.example.spotifyide.viewmodels.MainScreenViewModel
import com.example.spotifyide.viewmodels.SharedViewModel
import com.squareup.moshi.Moshi

@Composable
fun MainScreen(
    navController: NavController? = null,
    sharedViewModel:SharedViewModel? = null,
    index:Int = 0,
    mainScreenViewModel: MainScreenViewModel = hiltViewModel()
) {

    Column {
        val listOfStuff = listOf(
            User(id = 0, name = "user 0"),
            User(id = 1, name = "user 1"),
            User(id = 2, name = "user 2")
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(listOfStuff) { listItem ->
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter(User::class.java).lenient()
                val userJson = jsonAdapter.toJson(listItem)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(8.dp)
                        .clickable {
                            // simple string navController?.navigate("${Screen.OtherScreen.route}/${listItem} link clicked")
                            navController?.navigate("${Screen.OtherScreen.route}/${userJson}")
                        }
                ) {
                    Text(text = listItem.name)
                }
            }
        }
        Text(text = "${mainScreenViewModel.title} ${sharedViewModel?.number?:0}")
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    sharedViewModel?.incrementNumber()
                    navController?.navigate(Screen.OtherScreen.route)
            }) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(8.dp)
                ) {
                    Text(text = "other screen")
                }
            }
        }
    }
}

@JsonClass(generateAdapter = true)
data class User(val id: Int, val name: String)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpotifyIDETheme {
        MainScreen()
    }
}