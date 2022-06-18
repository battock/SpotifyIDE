package com.example.spotifyide.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.spotifyide.data.data.Album

@Database(entities = [Album::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}