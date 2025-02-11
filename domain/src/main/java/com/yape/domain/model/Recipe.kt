package com.yape.domain.model

data class Recipe(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val ingredients: List<String>,
    val country: String,
    val latitude: Double,
    val longitude: Double
)