package com.yape.challengeyape

import com.yape.domain.model.Recipe
import com.yape.domain.repository.DataRepository
import com.yape.domain.usecase.GetDataUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetDataUseCaseTest {

    private lateinit var getDataUseCase: GetDataUseCase
    private val repository: DataRepository = mock()

    @Before
    fun setUp() {
        getDataUseCase = GetDataUseCase(repository)
    }

    @Test
    fun `invoke should return list of recipes when repository returns data`() = runTest {
        val mockData = listOf(
            Recipe(1, "Ceviche", "image.jpg", "Delicious", listOf("Fish", "Lime"), "Peru", -12.0, -77.0)
        )

        whenever(repository.getData()).thenReturn(mockData)

        val result = getDataUseCase()
        assertEquals(mockData, result)
    }
}