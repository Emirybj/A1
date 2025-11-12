package com.example.a1.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a1.model.entity.Playlist
import com.example.a1.model.entity.SongCache
import kotlinx.coroutines.flow.Flow

@Dao
interface MusicDao {

    @Insert
    suspend fun insertPlaylist(playlist: Playlist)

    @Query("SELECT * FROM playlists ORDER BY nome ASC")
    fun getAllPlaylists(): Flow<List<Playlist>>

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun insertSong(song: SongCache)

    @Query("SELECT * FROM song_cache WHERE songApiId = :id")
    suspend fun getSongById(id: String): SongCache?
}