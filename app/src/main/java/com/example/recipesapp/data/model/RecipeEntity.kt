package com.example.recipesapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey val id: String,
    val description: String,
    val headline: String,
    val image: String,
    val ingredients: List<String>,
    val name: String,
)
