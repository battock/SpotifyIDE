package com.example.spotifyide.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.spotifyide.data.data.Album

@Dao
interface AlbumDao {
    @Query("SELECT * FROM album")
    suspend fun getAllAlbums(): List<Album>

    @Insert
    suspend fun addAllAlbums(albums:List<Album>)
//    @Query("SELECT * FROM album WHERE id IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<Album>
//
//    @Query("SELECT * FROM album WHERE title LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): Album

    @Insert
    suspend fun insertAll(vararg albums: Album)

    @Delete
    suspend fun delete(albums: Album)
}