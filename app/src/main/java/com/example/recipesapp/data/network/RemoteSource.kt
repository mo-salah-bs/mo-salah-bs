package com.example.recipesapp.data.network

import com.example.recipesapp.data.model.Recipe
import retrofit2.create

class RemoteSource: IRemoteSource {
    override suspend fun getRecipes(): List<Recipe> {
        return RetrofitApi.getInstance().getRecipes()
    }
}