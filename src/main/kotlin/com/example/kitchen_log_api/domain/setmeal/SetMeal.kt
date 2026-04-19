package com.example.kitchen_log_api.domain.setmeal

import com.example.kitchen_log_api.domain.recipe.Recipe
import com.example.kitchen_log_api.domain.user.User
import java.time.LocalDateTime

data class SetMeal(
    val id: Id,
    val userId: User.Id,
    val title: Title,
    val memo: Memo? = null,
    val recipeIds: List<Recipe.Id>,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt
) {
    @JvmInline
    value class Id(val value: Long)

    @JvmInline
    value class Title(val value: String)

    @JvmInline
    value class Memo(val value: String)

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}