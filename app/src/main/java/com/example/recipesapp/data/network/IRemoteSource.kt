package com.example.recipesapp.data.network

import com.example.recipesapp.data.model.Recipe

interface IRemoteSource {
    suspend fun getRecipes(): List<Recipe>
}