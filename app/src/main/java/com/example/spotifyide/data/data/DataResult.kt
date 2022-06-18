package com.example.spotifyide.data.data

sealed class Response {
    data class Success(val data: Any) : Response()
    data class Error(val exception: Exception) : Response()
}