package com.example.kitchen_log_api.domain.exception

open class KitchenLogApiException (
    message: String? = null,
    cause: Throwable? = null,
): RuntimeException(message, cause)