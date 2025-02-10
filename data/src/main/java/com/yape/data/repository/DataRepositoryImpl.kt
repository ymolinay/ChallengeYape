package com.yape.data.repository

import com.yape.data.remote.ApiService
import com.yape.domain.model.Recipe
import com.yape.domain.repository.DataRepository

class DataRepositoryImpl(private val apiService: ApiService) : DataRepository {
    override suspend fun getData(): List<Recipe> {
        return apiService.getData().map { it.toEntity() }
    }
}