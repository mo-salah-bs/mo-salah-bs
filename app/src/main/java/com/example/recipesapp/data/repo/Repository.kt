package com.example.recipesapp.data.repo

import android.content.Context
import com.example.recipesapp.data.database.ILocalSource
import com.example.recipesapp.data.database.LocalSource
import com.example.recipesapp.data.model.Recipe
import com.example.recipesapp.data.model.RecipeEntity
import com.example.recipesapp.data.network.IRemoteSource
import com.example.recipesapp.data.network.RemoteSource

class Repository(private val remoteSource: IRemoteSource, private val localSource: ILocalSource) :
    IRepository {

    companion object {
        private var instance: Repository? = null

        @JvmStatic
        fun getInstance(context: Context): Repository {
            return instance ?: Repository(RemoteSource(), LocalSource(context))
        }
    }

    override suspend fun getRecipes(): List<Recipe> {
        return remoteSource.getRecipes()
    }

    override suspend fun getAll(): List<RecipeEntity>? {
        return localSource.getAll()
    }

    override suspend fun findById(id: String): RecipeEntity? {
        return localSource.findById(id)
    }

    override suspend fun insert(recipe: RecipeEntity): Unit? {
        return localSource.insert(recipe)
    }

    override suspend fun delete(recipe: RecipeEntity): Unit? {
        return localSource.delete(recipe)
    }
}