package com.example.recipesapp.data.repo

import com.example.recipesapp.data.model.Recipe
import com.example.recipesapp.data.model.RecipeEntity

interface IRepository {
    suspend fun getRecipes(): List<Recipe>

    suspend fun getAll(): List<RecipeEntity>?

    suspend fun findById(id: String): RecipeEntity?

    suspend fun insert(recipe: RecipeEntity): Unit?

    suspend fun delete(recipe: RecipeEntity): Unit?
}