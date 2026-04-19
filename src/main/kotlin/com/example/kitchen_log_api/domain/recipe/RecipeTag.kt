package com.example.kitchen_log_api.domain.recipe

import com.example.kitchen_log_api.domain.user.User
import java.time.LocalDateTime

data class RecipeTag(
    val id: Id,
    val recipeId: Recipe.Id,
    val userId: User.Id,
    val name: Name,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt
) {
    @JvmInline
    value class Id(val value: Long)

    @JvmInline
    value class Name(val value: String)

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}