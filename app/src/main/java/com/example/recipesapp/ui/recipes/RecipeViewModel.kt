package com.example.recipesapp.ui.recipes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.data.model.Recipe
import com.example.recipesapp.data.repo.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(val repository: IRepository) : ViewModel() {
    private var mutableRecipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val recipes: LiveData<List<Recipe>> = mutableRecipes

    init {
        loadRecipes()
    }

    private fun loadRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            mutableRecipes.postValue(repository.getRecipes())
            Log.d("RECIPES_DATA", mutableRecipes.value.toString())
        }
    }
}