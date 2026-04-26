package com.example.kitchen_log_api.domain.exception

class InvalidParameterException(
    message: String? = null,
    cause: Throwable? = null,
): KitchenLogApiException(message, cause)