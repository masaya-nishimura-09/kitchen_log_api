package com.example.kitchen_log_api.infrastructure.recipe.repository

import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeTagEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface RecipeTagCrudRepository: CoroutineCrudRepository<RecipeTagEntity, Long> {
    suspend fun findAllByRecipeId(recipeId: Long): Flow<RecipeTagEntity>
}