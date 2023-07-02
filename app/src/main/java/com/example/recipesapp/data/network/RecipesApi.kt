package com.example.recipesapp.data.network

import com.example.recipesapp.data.model.Recipe
import retrofit2.http.GET


interface RecipesApi {
    @GET("/43427003d33f1f6b51cc")
    suspend fun getRecipes(): List<Recipe>
}