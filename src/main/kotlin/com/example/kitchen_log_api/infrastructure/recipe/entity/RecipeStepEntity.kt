package com.example.kitchen_log_api.infrastructure.recipe.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("steps")
data class RecipeStepEntity (
    @Id
    val id: Long? = null,
    val recipeId: Long,
    val userId: Long,
    val text: String,
    val order: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)