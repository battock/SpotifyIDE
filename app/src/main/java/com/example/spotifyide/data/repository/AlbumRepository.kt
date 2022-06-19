package com.example.spotifyide.data.repository

import com.example.spotifyide.data.data.Album
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    suspend fun fetchAlbums():List<Album>
    suspend fun refreshDataBase():Flow<List<Album>>
}