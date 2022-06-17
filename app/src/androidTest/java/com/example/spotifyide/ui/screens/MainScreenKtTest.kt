package com.example.spotifyide.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import com.example.spotifyide.ui.theme.SpotifyIDETheme
import com.example.spotifyide.viewmodels.MainScreenViewModel
import com.example.spotifyide.viewmodels.SharedViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenKtTest(){

    @get:Rule()
    val composeTestRule = createComposeRule()

    @MockK
    private lateinit var viewModel: SharedViewModel

    @RelaxedMockK
    private lateinit var mainViewModel: MainScreenViewModel

    @RelaxedMockK
    private lateinit var navController: NavController

    @Before  fun setUp() {
        MockKAnnotations.init(this)
        composeTestRule.setContent {
            SpotifyIDETheme{
                MainScreen(navController,viewModel,mainViewModel)
            }
        }
    }

    @Test
    fun mainTitle_shows() {
        composeTestRule.onNodeWithText(MAIN_HEADER_DESCRIPTION)
            .assertIsDisplayed()
    }

}