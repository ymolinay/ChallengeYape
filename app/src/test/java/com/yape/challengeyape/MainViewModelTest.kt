package com.yape.challengeyape

import com.yape.challengeyape.viewmodel.MainViewModel
import com.yape.challengeyape.viewmodel.UiState
import com.yape.domain.model.Recipe
import com.yape.domain.usecase.GetDataUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class MainViewModelTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: MainViewModel
    private val getDataUseCase: GetDataUseCase = mock()

    @Before
    fun setUp() {
        viewModel = MainViewModel(getDataUseCase)
    }

    @Test
    fun `fetchData should update uiState with success when data is retrieved`() = runTest {
        val mockData = listOf(
            Recipe(1, "Ceviche", "image.jpg", "Delicious", listOf("Fish", "Lime"), "Peru", -12.0, -77.0)
        )

        whenever(getDataUseCase()).thenReturn(mockData)

        viewModel.fetchData()

        val result = viewModel.uiState.first()
        assertEquals(UiState.Success(mockData), result)
    }
}