package com.example.recipesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val calories: String,
    val carbos: String,
    val country: String,
    val deliverable_ingredients: List<String>,
    val description: String,
    val difficulty: Int,
    val fats: String,
    val favorites: Int,
    val fibers: String,
    val headline: String,
    val highlighted: Boolean,
    val id: String,
    val image: String,
    val ingredients: List<String>,
    val keywords: List<String>,
    val name: String,
    val products: List<String>,
    val proteins: String,
    val rating: Double,
    val ratings: Int,
    val time: String,
    val weeks: List<String>
) : Parcelable