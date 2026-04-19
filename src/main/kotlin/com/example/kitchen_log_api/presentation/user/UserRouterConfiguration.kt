package com.example.kitchen_log_api.presentation.user

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class UserRouterConfiguration {
    @Bean
    fun userRouter(userHandler: UserHandler) = coRouter {
        GET("users", userHandler::fetchAllUsers )
    }
}