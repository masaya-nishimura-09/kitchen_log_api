package com.example.kitchen_log_api.infrastructure.recipe.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("recipes")
data class RecipeEntity (
    @Id
    val id: Long? = null,
    val userId: Long,
    val title: String,
    val imageUrl: String?,
    val memo: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)