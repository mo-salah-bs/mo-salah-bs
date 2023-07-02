package com.example.recipesapp.data.database

import android.content.Context
import com.example.recipesapp.data.model.RecipeEntity

class LocalSource(private val context: Context) : ILocalSource {
    override suspend fun getAll(): List<RecipeEntity>? {
        return DatabaseHelper.getInstance(context)?.getAll()
    }

    override suspend fun findById(id: String): RecipeEntity? {
        return DatabaseHelper.getInstance(context)?.findById(id)
    }

    override suspend fun insert(recipe: RecipeEntity): Unit? {
        return DatabaseHelper.getInstance(context)?.insert(recipe)
    }

    override suspend fun delete(recipe: RecipeEntity): Unit? {
        return DatabaseHelper.getInstance(context)?.delete(recipe)
    }
}