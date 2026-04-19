package com.example.kitchen_log_api.infrastructure.recipe

import com.example.kitchen_log_api.domain.recipe.Recipe
import com.example.kitchen_log_api.domain.recipe.RecipeIngredient
import com.example.kitchen_log_api.domain.recipe.RecipeRepository
import com.example.kitchen_log_api.domain.recipe.RecipeStep
import com.example.kitchen_log_api.domain.recipe.RecipeTag
import com.example.kitchen_log_api.domain.user.User
import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeEntity
import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeIngredientEntity
import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeStepEntity
import com.example.kitchen_log_api.infrastructure.recipe.entity.RecipeTagEntity
import com.example.kitchen_log_api.infrastructure.recipe.repository.RecipeCrudRepository
import com.example.kitchen_log_api.infrastructure.recipe.repository.RecipeIngredientCrudRepository
import com.example.kitchen_log_api.infrastructure.recipe.repository.RecipeStepCrudRepository
import com.example.kitchen_log_api.infrastructure.recipe.repository.RecipeTagCrudRepository
import kotlinx.coroutines.flow.toList
import org.springframework.dao.DataAccessException

class RecipeRepositoryImpl(
    private val recipeCrudRepository: RecipeCrudRepository,
    private val recipeTagCrudRepository: RecipeTagCrudRepository,
    private val recipeIngredientCrudRepository: RecipeIngredientCrudRepository,
    private val recipeStepCrudRepository: RecipeStepCrudRepository
) : RecipeRepository {
    internal fun toRecipe(
        recipeEntity: RecipeEntity,
        tags: List<RecipeTagEntity>,
        ingredients: List<RecipeIngredientEntity>,
        steps: List<RecipeStepEntity>
    ): Recipe =
        Recipe(
            id = Recipe.Id(recipeEntity.id!!),
            userId = User.Id(recipeEntity.userId),
            title = Recipe.Title(recipeEntity.title),
            imageUrl = recipeEntity.imageUrl?.let { Recipe.ImageUrl(it) },
            memo = recipeEntity.memo?.let { Recipe.Memo(it) },
            tags = tags.map { tag ->
                RecipeTag(
                    id = RecipeTag.Id(tag.id!!),
                    recipeId = Recipe.Id(tag.recipeId),
                    userId = User.Id(tag.userId),
                    name = RecipeTag.Name(tag.name),
                    createdAt = RecipeTag.CreatedAt(tag.createdAt),
                    updatedAt = RecipeTag.UpdatedAt(tag.updatedAt)
                )
            },
            ingredients = ingredients.map { ingredient ->
                RecipeIngredient(
                    id = RecipeIngredient.Id(ingredient.id!!),
                    recipeId = Recipe.Id(ingredient.recipeId),
                    userId = User.Id(ingredient.userId),
                    name = RecipeIngredient.Name(ingredient.name),
                    amount = ingredient.amount?.let { RecipeIngredient.Amount(it) },
                    measurementUnit = RecipeIngredient.MeasurementUnit(ingredient.measurementUnit),
                    order = RecipeIngredient.Order(ingredient.order),
                    createdAt = RecipeIngredient.CreatedAt(ingredient.createdAt),
                    updatedAt = RecipeIngredient.UpdatedAt(ingredient.updatedAt)
                )
            },
            steps = steps.map { step ->
                RecipeStep(
                    id = RecipeStep.Id(step.id!!),
                    recipeId = Recipe.Id(step.recipeId),
                    userId = User.Id(step.userId),
                    text = RecipeStep.Text(step.text),
                    order = RecipeStep.Order(step.order),
                    createdAt = RecipeStep.CreatedAt(step.createdAt),
                    updatedAt = RecipeStep.UpdatedAt(step.updatedAt)
                )
            },
            createdAt = Recipe.CreatedAt(recipeEntity.createdAt),
            updatedAt = Recipe.UpdatedAt(recipeEntity.updatedAt)
        )

    override suspend fun fetchRecipes(userId: User.Id): List<Recipe> {
        try {
            val recipeEntities = recipeCrudRepository.findAllByUserId(userId.value).toList()
            return recipeEntities.map { recipeEntity ->
                val tags = recipeTagCrudRepository
                    .findAllByRecipeId(recipeEntity.id!!).toList()
                val ingredients = recipeIngredientCrudRepository
                    .findAllByRecipeId(recipeEntity.id).toList()
                val steps = recipeStepCrudRepository
                    .findAllByRecipeId(recipeEntity.id).toList()

                toRecipe(recipeEntity, tags, ingredients, steps)
            }
        } catch (ex: DataAccessException) {
//            throw RecipeFetchFailedException("予期せぬエラーが発生しました")
            TODO("Not yet implemented")
        }
    }

    override suspend fun fetchRecipeById(id: Recipe.Id): Recipe {
        TODO("Not yet implemented")
    }

    override suspend fun createRecipe(recipe: Recipe): Recipe {
        TODO("Not yet implemented")
    }

    override suspend fun updateRecipe(recipe: Recipe): Recipe {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRecipe(id: Recipe.Id) {
        TODO("Not yet implemented")
    }
}