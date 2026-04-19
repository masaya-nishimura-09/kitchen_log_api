package com.example.kitchen_log_api.domain.recipe

import com.example.kitchen_log_api.domain.user.User
import java.time.LocalDateTime

data class Recipe(
    val id: Id,
    val userId: User.Id,
    val title: Title,
    val imageUrl: ImageUrl?,
    val memo: Memo?,
    val tags: List<RecipeTag>,
    val ingredients: List<RecipeIngredient>,
    val steps: List<RecipeStep>,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt
) {
    @JvmInline
    value class Id(val value: Long)

    @JvmInline
    value class Title(val value: String)

    @JvmInline
    value class ImageUrl(val value: String)

    @JvmInline
    value class Memo(val value: String)

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}