package com.example.spotifyide.data.api.dataFlow

import com.example.spotifyide.data.api.ApiService
import com.example.spotifyide.data.data.Album
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AlbumsFlowSource{
    val latestAlbums: Flow<List<Album>>
}
