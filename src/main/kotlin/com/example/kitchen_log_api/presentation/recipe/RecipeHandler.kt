package com.example.kitchen_log_api.presentation.recipe

import com.example.kitchen_log_api.application.recipe.RecipeUseCase
import com.example.kitchen_log_api.domain.recipe.Recipe
import com.example.kitchen_log_api.domain.user.User
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import java.time.format.DateTimeFormatter

@Component
class RecipeHandler(
    private val recipeUseCase: RecipeUseCase,
) {
    internal fun toRecipeResponse(recipe: Recipe): RecipeResponse =
        RecipeResponse(
            id = recipe.id.value,
            title = recipe.title.value,
            imageUrl = recipe.imageUrl?.value,
            memo = recipe.memo?.value,
            tags = recipe.tags.map { RecipeResponse.TagResponse(
                id = it.id.value,
                name = it.name.value
            ) },
            ingredients = recipe.ingredients.map { RecipeResponse.IngredientResponse(
                id = it.id.value,
                name = it.name.value,
                amount = it.amount?.value,
                measurementUnit = it.measurementUnit.value,
                order = it.order.value
            ) },
            steps = recipe.steps.map { RecipeResponse.StepResponse(
                id = it.id.value,
                text = it.text.value,
                order = it.order.value
            ) },
            createdAt = recipe.createdAt.value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            updatedAt = recipe.updatedAt.value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        )


    suspend fun fetchAllRecipes(request: ServerRequest): ServerResponse {
        // TODO("fix userId later")
        val userId = 0

        return try {
            val recipeResponses =
                recipeUseCase
                    .fetchAllRecipes(User.Id(userId.toLong()))
                    .map { recipe -> toRecipeResponse(recipe) }

            ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValueAndAwait(recipeResponses)
        } catch (ex: Exception) {
            TODO()
        }
    }
}