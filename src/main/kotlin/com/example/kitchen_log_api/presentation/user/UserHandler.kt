package com.example.kitchen_log_api.presentation.user

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class UserHandler {
    suspend fun fetchAllUsers(request: ServerRequest): ServerResponse {
        val userDtos = {}
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(userDtos)
    }
}