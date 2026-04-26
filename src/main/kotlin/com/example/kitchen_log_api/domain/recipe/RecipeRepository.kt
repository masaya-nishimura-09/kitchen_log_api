package com.example.kitchen_log_api.domain.recipe

import com.example.kitchen_log_api.domain.user.User

interface RecipeRepository {
    suspend fun fetchAllRecipes(userId: User.Id): List<Recipe>
    suspend fun fetchRecipeById(id: Recipe.Id): Recipe
    suspend fun createRecipe(recipe: Recipe): Recipe
    suspend fun updateRecipe(recipe: Recipe): Recipe
    suspend fun deleteRecipe(id: Recipe.Id): Unit
}