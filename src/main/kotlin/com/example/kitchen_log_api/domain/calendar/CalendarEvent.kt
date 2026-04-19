package com.example.kitchen_log_api.domain.calendar

import com.example.kitchen_log_api.domain.recipe.Recipe
import com.example.kitchen_log_api.domain.user.User
import java.time.LocalDate
import java.time.LocalDateTime

data class CalendarEvent(
    val id: Id,
    val userId: User.Id,
    val recipeId: Recipe.Id,
    val eventDate: EventDate,
    val color: EventColor,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt
) {
    @JvmInline
    value class Id(val value: Long)

    @JvmInline
    value class EventDate(val value: LocalDate)

    enum class EventColor {
        BLUE,
        RED,
        YELLOW,
        ORANGE,
        PURPLE,
        PINK,
        BROWN,
        GRAY,
    }

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}