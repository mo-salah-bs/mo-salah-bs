package com.example.recipesapp.ui.recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipesapp.data.repo.IRepository

class RecipeViewModelFactory(
    private val repository: IRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RecipeViewModel::class.java)) {
            RecipeViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Recipe view model not assigned")
        }
    }
}