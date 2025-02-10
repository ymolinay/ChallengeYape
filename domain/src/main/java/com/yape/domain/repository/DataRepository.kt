package com.yape.domain.repository

import com.yape.domain.model.Recipe

interface DataRepository {
    suspend fun getData(): List<Recipe>
}