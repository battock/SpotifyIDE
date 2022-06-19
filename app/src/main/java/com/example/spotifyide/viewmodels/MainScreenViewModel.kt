package com.example.spotifyide.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotifyide.data.data.Album
import com.example.spotifyide.data.repository.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    val repository: AlbumRepository
):ViewModel() {
    val LOGGING_TAG = this.javaClass.simpleName
    var title by mutableStateOf("Main title")
        private set

    private val _albums = MutableLiveData<List<Album>>(emptyList())
    val albums: LiveData<List<Album>> = _albums

    init {
        fetchAlbums()
    }

    private fun fetchAlbums(){
        viewModelScope.launch {
                repository.refreshDataBase()
                    .catch {
                        Log.d(LOGGING_TAG, it.message.toString())
                    }
                    .collect{
                        result->_albums.postValue(result)
                        Log.d(LOGGING_TAG, "data collected $result")
                }
        }
    }
}