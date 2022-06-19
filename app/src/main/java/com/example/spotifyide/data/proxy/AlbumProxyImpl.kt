package com.example.spotifyide.data.proxy

import com.example.spotifyide.data.api.ApiService
import com.example.spotifyide.data.data.Album
import com.example.spotifyide.data.db.AlbumDao
import com.example.spotifyide.data.repository.AlbumProxy
import java.lang.Exception
import javax.inject.Inject

class AlbumProxyImpl @Inject constructor(
    private val api: ApiService
) : AlbumProxy {
    override suspend fun fetchAlbums(): List<Album> {
        //todo convert from network object to lcoal UI object
        return api.getAlbums()
    }
}