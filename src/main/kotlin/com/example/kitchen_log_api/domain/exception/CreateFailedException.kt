package com.example.kitchen_log_api.domain.exception

class CreateFailedException(
    message: String?,
    cause: Throwable?,
): KitchenLogApiException(message, cause)