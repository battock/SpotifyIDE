package com.example.spotifyide.data.repository

import com.example.spotifyide.data.data.Album

interface AlbumProxy {
    suspend fun fetchAlbums():List<Album>
}