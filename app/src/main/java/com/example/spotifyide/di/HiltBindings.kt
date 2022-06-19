package com.example.spotifyide.di

import com.example.spotifyide.data.api.dataFlow.AlbumsFlowSource
import com.example.spotifyide.data.api.dataFlow.AlbumsFlowSourceImpl
import com.example.spotifyide.data.repository.AlbumProxy
import com.example.spotifyide.data.proxy.AlbumProxyImpl
import com.example.spotifyide.data.repository.AlbumRepository
import com.example.spotifyide.data.repository.AlbumRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface HiltBindings  {

    @Binds
    @Singleton
    fun provideProxy(albumProxy: AlbumProxyImpl) :AlbumProxy

    @Binds
    @Singleton
    fun provideRepo(albumRepository: AlbumRepositoryImpl) :AlbumRepository

    @Binds
    @Singleton
    fun provideFlowSource(albumFlow: AlbumsFlowSourceImpl) :AlbumsFlowSource
}