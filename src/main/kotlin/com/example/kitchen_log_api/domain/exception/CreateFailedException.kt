package com.example.kitchen_log_api.domain.exception

open class CreateFailedException(
    message: String?,
    cause: Throwable?,
): KitchenLogApiException(message, cause)