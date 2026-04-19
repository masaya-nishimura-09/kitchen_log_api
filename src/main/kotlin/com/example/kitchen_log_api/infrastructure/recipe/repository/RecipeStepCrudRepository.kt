package com.example.kitchen_log_api.infrastructure.recipe.repository

import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeStepEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface RecipeStepCrudRepository: CoroutineCrudRepository<RecipeStepEntity, Long> {
    suspend fun findAllByRecipeId(recipeId: Long): Flow<RecipeStepEntity>
}