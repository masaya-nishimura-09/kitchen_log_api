package com.example.kitchen_log_api.infrastructure.recipe.repository

import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeIngredientEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface RecipeIngredientCrudRepository: CoroutineCrudRepository<RecipeIngredientEntity, Long> {
    suspend fun findAllByRecipeId(recipeId: Long): Flow<RecipeIngredientEntity>
}