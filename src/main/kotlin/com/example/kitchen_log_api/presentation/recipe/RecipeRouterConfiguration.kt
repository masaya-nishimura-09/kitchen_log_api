package com.example.kitchen_log_api.presentation.recipe

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RecipeRouterConfiguration {
    @Bean
    fun recipeRouter(recipeHandler: RecipeHandler) = coRouter {
        GET("/recipes", recipeHandler::fetchAllRecipes )
    }
}