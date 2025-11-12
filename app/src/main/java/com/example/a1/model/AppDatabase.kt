package com.example.a1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a1.model.dao.MusicDao
import com.example.a1.model.entity.Playlist
import com.example.a1.model.entity.SongCache

@Database(entities = [Playlist::class, SongCache::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun musicDao(): MusicDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "music_app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}