package com.example.spotifyide.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
) {
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Main title")
    }
}