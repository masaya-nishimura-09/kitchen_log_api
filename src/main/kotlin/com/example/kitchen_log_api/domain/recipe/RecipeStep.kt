package com.example.kitchen_log_api.domain.recipe

import com.example.kitchen_log_api.domain.user.User
import java.time.LocalDateTime

data class RecipeStep(
    val id: Id,
    val recipeId: Recipe.Id,
    val userId: User.Id,
    val text: Text,
    val order: Order,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt
) {
    @JvmInline
    value class Id(val value: Long)

    @JvmInline
    value class Text(val value: String)

    @JvmInline
    value class Order(val value: Int)

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}