package com.example.spotifyide.data.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.JsonAdapter
import com.squareup.moshi.JsonClass


//without room
//@JsonClass(generateAdapter = true)
//data class Album(
//    val userId: Int? = null,
//    val id: Int? = null,
//    val title: String? = null
//)

//with room
@JsonClass(generateAdapter = true)
@Entity
data class Album(
    @PrimaryKey(autoGenerate = true) val PK:Int,
    val userId: Int? = null,
    @ColumnInfo(name = "first_name")  val id: Int? = null,
    @ColumnInfo(name = "last_name")  val title: String? = null
)
