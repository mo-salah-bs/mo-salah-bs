package com.example.recipesapp.ui.recipes_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipesapp.data.repo.IRepository

class RecipeDetailsViewModelFactory(
    private val repository: IRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RecipeDetailsViewModel::class.java)) {
            RecipeDetailsViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Recipe Details view model not assigned")
        }
    }
}