package com.example.recipesapp.data.database

import androidx.room.*
import com.example.recipesapp.data.model.RecipeEntity

@Dao
interface RecipeDao {
    @Query("SELECT* FROM recipe")
    suspend fun getAll(): List<RecipeEntity>

    @Query("SELECT* FROM recipe WHERE id LIKE :id")
    suspend fun findById(id: String): RecipeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: RecipeEntity)

    @Delete
    suspend fun delete(recipe: RecipeEntity)
}