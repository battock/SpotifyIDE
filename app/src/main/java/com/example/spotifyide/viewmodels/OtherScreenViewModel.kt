package com.example.spotifyide.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtherScreenViewModel @Inject constructor():ViewModel() {

    var title by mutableStateOf("Other title")
        private set


}