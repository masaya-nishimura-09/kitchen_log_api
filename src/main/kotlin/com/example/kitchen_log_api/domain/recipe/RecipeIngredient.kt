package com.example.kitchen_log_api.domain.recipe

import com.example.kitchen_log_api.domain.user.User
import java.time.LocalDateTime

data class RecipeIngredient(
    val id: Id,
    val recipeId: Recipe.Id,
    val userId: User.Id,
    val name: Name,
    val amount: Amount,
    val unit: Unit,
    val order: Order,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt
) {
    @JvmInline
    value class Id(val value: Long)

    @JvmInline
    value class Name(val value: String)

    @JvmInline
    value class Amount(val value: String)

    @JvmInline
    value class Unit(val value: String)

    @JvmInline
    value class Order(val value: Int)

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}