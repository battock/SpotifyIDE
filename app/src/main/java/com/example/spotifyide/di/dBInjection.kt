package com.example.spotifyide.di

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import com.example.spotifyide.data.db.AlbumDao
import com.example.spotifyide.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAlbumDao(appDatabase: AppDatabase): AlbumDao {
        return appDatabase.albumDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "albums_db"
        ).build()
    }
}

