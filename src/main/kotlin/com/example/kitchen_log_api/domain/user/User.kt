package com.example.kitchen_log_api.domain.user

import java.time.LocalDateTime

data class User(
    val id: Id,
    val username: Username,
    val email: Email,
    val password: Password,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt
) {
    @JvmInline
    value class Id(val value: Long)

    @JvmInline
    value class Username(val value: String)

    @JvmInline
    value class Email(val value: String)

    @JvmInline
    value class Password(val value: String)

    @JvmInline
    value class CreatedAt(val value: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val value: LocalDateTime)
}