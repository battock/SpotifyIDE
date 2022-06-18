package com.example.spotifyide.data.api

import com.example.spotifyide.data.data.Album
import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>
}