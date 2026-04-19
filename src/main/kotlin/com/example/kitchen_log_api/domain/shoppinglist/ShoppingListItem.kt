package com.example.kitchen_log_api.domain.shoppinglist

import com.example.kitchen_log_api.domain.user.User
import java.time.LocalDateTime

data class ShoppingListItem(
    val id: Id,
    val userId: User.Id,
    val name: Name,
    val amount: Amount? = null,
    val measurementUnit: MeasurementUnit,
    val status: Status,
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
    value class MeasurementUnit(val value: String)

    @JvmInline
    value class Status(val value: Boolean)

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}