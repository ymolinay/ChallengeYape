package com.yape.data.model

import com.google.gson.annotations.SerializedName
import com.yape.domain.model.Recipe

data class RecipeDto(
    val id: Int,
    val name: String,
    @SerializedName("imageUrl") val imageUrl: String,
    val description: String,
    val ingredients: List<String>,
    val origin: OriginDto
) {
    fun toEntity() = Recipe(
        id,
        name,
        imageUrl,
        description,
        ingredients,
        origin.country,
        origin.latitude,
        origin.longitude,
    )
}

data class OriginDto(
    val country: String,
    val latitude: Double,
    val longitude: Double
)