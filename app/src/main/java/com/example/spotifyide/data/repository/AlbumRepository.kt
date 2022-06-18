package com.example.spotifyide.data.repository

import com.example.spotifyide.data.data.Album

interface AlbumRepository {
    suspend fun fetchAlbums():List<Album>
}