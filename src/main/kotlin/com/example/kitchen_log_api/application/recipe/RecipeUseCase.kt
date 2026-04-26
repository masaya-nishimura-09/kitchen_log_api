package com.example.kitchen_log_api.application.recipe

import com.example.kitchen_log_api.domain.recipe.Recipe
import com.example.kitchen_log_api.domain.recipe.RecipeRepository
import com.example.kitchen_log_api.domain.user.User
import org.springframework.stereotype.Service

@Service
class RecipeUseCase(
    private val recipeRepository: RecipeRepository,
) {
    suspend fun fetchRecipes(userId: User.Id): List<Recipe> = recipeRepository.fetchRecipes(userId)
}