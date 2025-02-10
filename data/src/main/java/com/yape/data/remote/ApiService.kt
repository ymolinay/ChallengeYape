package com.yape.data.remote

import com.yape.data.model.RecipeDto
import retrofit2.http.GET

interface ApiService {
    @GET("getData")
    suspend fun getData(): List<RecipeDto>
}