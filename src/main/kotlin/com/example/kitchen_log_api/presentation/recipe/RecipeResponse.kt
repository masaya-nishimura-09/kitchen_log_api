package com.example.kitchen_log_api.presentation.recipe

data class RecipeResponse(
    val id: Long,
    val title: String,
    val imageUrl: String?,
    val memo: String?,
    val tags: List<TagResponse>,
    val ingredients: List<IngredientResponse>,
    val steps: List<StepResponse>,
    val createdAt: String,
    val updatedAt: String
) {
    data class TagResponse(
        val id: Long,
        val name: String
    )

    data class IngredientResponse(
        val id: Long,
        val name: String,
        val amount: String?,
        val measurementUnit: String,
        val order: Long
    )

    data class StepResponse(
        val id: Long,
        val text: String,
        val order: Long
    )
}