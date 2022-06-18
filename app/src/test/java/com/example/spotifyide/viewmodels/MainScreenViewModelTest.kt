package com.example.spotifyide.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.spotifyide.data.repository.AlbumRepository
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class MainScreenViewModelTest{

    @RelaxedMockK
    private lateinit var repository: AlbumRepository

    private lateinit var viewModel:MainScreenViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        coEvery { repository.fetchAlbums() } returns listOf()
        viewModel = MainScreenViewModel(repository)
    }

    @Test
    fun onViewModelInitialization_repositoryFetchesAlbums() = runTest{
        coVerify { repository.fetchAlbums() }
    }

}