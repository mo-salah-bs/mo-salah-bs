package com.example.recipesapp.data.database

import com.example.recipesapp.data.model.RecipeEntity

interface ILocalSource {
    suspend fun getAll(): List<RecipeEntity>?

    suspend fun findById(id: String): RecipeEntity?

    suspend fun insert(recipe: RecipeEntity): Unit?

    suspend fun delete(recipe: RecipeEntity): Unit?
}