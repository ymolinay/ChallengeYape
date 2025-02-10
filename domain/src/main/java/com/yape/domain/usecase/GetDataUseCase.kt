package com.yape.domain.usecase

import com.yape.domain.model.Recipe
import com.yape.domain.repository.DataRepository

class GetDataUseCase(private val repository: DataRepository) {
    suspend operator fun invoke(): List<Recipe> {
        return repository.getData()
    }
}