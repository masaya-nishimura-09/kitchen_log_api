package com.example.kitchen_log_api.domain.exception

open class FetchFailedException(
    message: String? = null,
    cause: Throwable? = null,
): KitchenLogApiException(message, cause)