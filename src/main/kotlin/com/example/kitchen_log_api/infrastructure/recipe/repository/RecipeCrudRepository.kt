package com.example.kitchen_log_api.infrastructure.recipe.repository

import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface RecipeCrudRepository: CoroutineCrudRepository<RecipeEntity, Long>