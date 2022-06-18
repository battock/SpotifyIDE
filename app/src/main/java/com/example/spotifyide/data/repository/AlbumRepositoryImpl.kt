package com.example.spotifyide.data.repository

import com.example.spotifyide.data.data.Album
import com.example.spotifyide.data.db.AlbumDao
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val proxy: AlbumProxy
) : AlbumRepository {
    override suspend fun fetchAlbums(): List<Album> {
        return proxy.fetchAlbums()
    }
}