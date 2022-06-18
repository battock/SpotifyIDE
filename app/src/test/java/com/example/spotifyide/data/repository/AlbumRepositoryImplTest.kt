package com.example.spotifyide.data.repository

import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

internal class AlbumRepositoryImplTest{

    @RelaxedMockK
    private lateinit var proxy: AlbumProxy

    private lateinit var repository: AlbumRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        coEvery { proxy.fetchAlbums() } returns listOf()
        repository = AlbumRepositoryImpl(proxy)
    }

    @Test
    fun repositoryFetchAlbums_callsProxyToFetchAlbums() = runTest{
        repository.fetchAlbums()
        coVerify { proxy.fetchAlbums() }
    }

}