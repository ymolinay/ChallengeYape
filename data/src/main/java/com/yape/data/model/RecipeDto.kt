package com.yape.data.model

import com.yape.domain.model.Recipe

data class RecipeDto(
    val id: Int,
    val name: String
) {
    fun toEntity() = Recipe(id, name)
}