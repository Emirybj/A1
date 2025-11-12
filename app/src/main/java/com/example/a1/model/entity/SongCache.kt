package com.example.a1.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song_cache")
data class SongCache(
    @PrimaryKey
    val songApiId: String,
    val titulo: String,
    val artista: String,
    val urlCapa: String,
    val urlAudio: String
)