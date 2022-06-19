package com.example.spotifyide.data.repository

import com.example.spotifyide.data.api.dataFlow.AlbumsFlowSource
import com.example.spotifyide.data.data.Album
import com.example.spotifyide.data.db.AlbumDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.lang.Exception
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val proxy: AlbumProxy,
    private val  flowSource: AlbumsFlowSource,
    private val albumDao : AlbumDao
) : AlbumRepository {
    override suspend fun fetchAlbums():List<Album> {
        return try {
            if (albumDao.getAllAlbums().isNullOrEmpty()) {
                albumDao.addAllAlbums(proxy.fetchAlbums())
            }
            albumDao.getAllAlbums()
        }
        catch(ex: Exception){
            emptyList()
        }
    }

    override suspend fun refreshDataBase():Flow<List<Album>> =
        flowSource.latestAlbums
            .map { albums-> albums.filter {
                (it.title?:"").isNotEmpty()
            }}
            .onEach {
                albums->albumDao.addAllAlbums(albums)
            }

}