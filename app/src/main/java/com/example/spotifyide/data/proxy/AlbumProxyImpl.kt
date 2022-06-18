package com.example.spotifyide.data.proxy

import com.example.spotifyide.data.api.ApiService
import com.example.spotifyide.data.data.Album
import com.example.spotifyide.data.db.AlbumDao
import com.example.spotifyide.data.repository.AlbumProxy
import java.lang.Exception
import javax.inject.Inject

class AlbumProxyImpl @Inject constructor(
    private val api: ApiService,
    private val albumDao : AlbumDao
) : AlbumProxy {
    override suspend fun fetchAlbums():List<Album> {
        return try {
            if (albumDao.getAllAlbums().isNullOrEmpty()) {
                albumDao.addAllAlbums(api.getAlbums())
            }
            albumDao.getAllAlbums()
        }
        catch(ex:Exception){
            emptyList()
        }
    }
}