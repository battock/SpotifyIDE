package com.example.spotifyide.data.proxy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.spotifyide.data.api.ApiService
import com.example.spotifyide.data.repository.AlbumProxy
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class AlbumProxyImplTest{

    @RelaxedMockK
    private lateinit var api: ApiService

    private lateinit var proxy: AlbumProxy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        coEvery { api.getAlbums() } returns listOf()
        proxy = AlbumProxyImpl(api)
    }

    @Test
    fun repositoryFetchAlbums_callsProxyToFetchAlbums() = runTest{
        proxy.fetchAlbums()
        coVerify { proxy.fetchAlbums() }
    }

}
