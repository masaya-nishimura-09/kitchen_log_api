package com.example.kitchen_log_api.infrastructure.recipe.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("tags")
data class RecipeTagEntity (
    @Id
    val id: Long? = null,
    val recipeId: Long,
    val userId: Long,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)