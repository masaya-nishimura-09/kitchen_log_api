package com.example.kitchen_log_api.infrastructure.recipe.repository

import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeTagEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface RecipeTagCrudRepository: CoroutineCrudRepository<RecipeTagEntity, Long>