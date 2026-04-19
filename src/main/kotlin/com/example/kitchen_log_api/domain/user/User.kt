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
    value class Id(val id: Long)

    @JvmInline
    value class Username(val username: String)

    @JvmInline
    value class Email(val email: String)

    @JvmInline
    value class Password(val password: String)

    @JvmInline
    value class CreatedAt(val createdAt: LocalDateTime)

    @JvmInline
    value class UpdatedAt(val updatedAt: LocalDateTime)
}