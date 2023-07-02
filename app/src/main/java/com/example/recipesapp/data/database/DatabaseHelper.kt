package com.example.recipesapp.data.database

import android.content.Context
import androidx.room.Room

class DatabaseHelper {
    companion object {
        private var dp: RecipeDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): RecipeDao? {
            if (dp == null) {
                dp = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java, "recipe_database"
                ).build()
            }
            return dp?.recipeDao()
        }
    }
}