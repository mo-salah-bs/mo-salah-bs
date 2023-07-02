package com.example.recipesapp.ui.recipes_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.data.model.Recipe
import com.example.recipesapp.data.model.RecipeEntity
import com.example.recipesapp.data.repo.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(private val repository: IRepository) : ViewModel() {

    private var _recipeEntity: MutableLiveData<RecipeEntity> = MutableLiveData()

    fun findRecipeById(id: String): LiveData<RecipeEntity> {
        viewModelScope.launch(Dispatchers.IO) {
            _recipeEntity.postValue(repository.findById(id))
        }
        return _recipeEntity
    }

    fun insertRecipe(recipe: Recipe) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(recipe = getRecipeEntityFromRecipe(recipe))
        }
    }

    fun deleteRecipe(recipe: Recipe) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(recipe = getRecipeEntityFromRecipe(recipe))
        }
    }

    private fun getRecipeEntityFromRecipe(recipe: Recipe): RecipeEntity {
        return RecipeEntity(
            id = recipe.id, name = recipe.name,
            description = recipe.description,
            headline = recipe.headline, image = recipe.image, ingredients = recipe.ingredients
        )
    }
}