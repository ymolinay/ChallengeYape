package com.yape.challengeyape

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yape.challengeyape.ui.MainScreen
import com.yape.challengeyape.viewmodel.MainViewModel
import com.yape.challengeyape.viewmodel.UiState
import com.yape.domain.model.Recipe
import com.yape.domain.usecase.GetDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMainScreenDisplaysRecipes() {
        val mockData = listOf(
            Recipe(1, "Ceviche", "image.jpg", "Delicious", listOf("Fish", "Lime"), "Peru", -12.0, -77.0)
        )

        // Fake ViewModel sin extender MainViewModel
        val fakeViewModel = object {
            val uiState = MutableStateFlow<UiState>(UiState.Success(mockData))
        }

        composeTestRule.setContent {
            MainScreen(navController = mock(), viewModel = fakeViewModel as MainViewModel)
        }

        // Verificar que se muestra el texto "Ceviche"
        composeTestRule.onNodeWithText("Ceviche").assertIsDisplayed()
    }
}