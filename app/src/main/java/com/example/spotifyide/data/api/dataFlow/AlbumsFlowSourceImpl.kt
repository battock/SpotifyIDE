package com.example.spotifyide.data.api.dataFlow

import com.example.spotifyide.data.api.ApiService
import com.example.spotifyide.data.data.Album
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



class AlbumsFlowSourceImpl @Inject constructor(
    private val apiService: ApiService
):AlbumsFlowSource {
    private val refreshIntervalMs: Long = 1000
    override val latestAlbums: Flow<List<Album>> = flow {
        while(true) {
            val latestAlbums = apiService.getAlbums()
            emit(latestAlbums) // Emits the result of the request to the flow
            delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }
}
