package com.example.recipesapp.ui.recipes_details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recipesapp.R
import com.example.recipesapp.data.model.Recipe
import com.example.recipesapp.data.repo.IRepository
import com.example.recipesapp.data.repo.Repository
import com.example.recipesapp.databinding.ActivityRecipeDetailsBinding
import com.example.recipesapp.utils.Constant

class RecipeDetailsActivity : AppCompatActivity() {

    private val binding: ActivityRecipeDetailsBinding by lazy {
        ActivityRecipeDetailsBinding.inflate(layoutInflater)
    }
    private val repository: IRepository by lazy {
        Repository.getInstance(this)
    }
    private val viewModel: RecipeDetailsViewModel by lazy {
        ViewModelProvider(
            this,
            RecipeDetailsViewModelFactory(repository)
        )[RecipeDetailsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        initUI()
    }

    override fun onResume() {
        super.onResume()
        initUI()
    }

    private fun initUI() {
        val recipe = intent.getParcelableExtra<Recipe>(Constant.SELECTED_RECIPE.name)
        Glide.with(this).load(recipe?.image)
            .into(binding.recipeImage)
        binding.recipeName.text = recipe?.name
        binding.recipeHeadline.text = recipe?.headline
        binding.recipeDescription.text = recipe?.description
        binding.recipeIngredients.text = recipe?.let { getRecipeIngredientsAsString(it) }

        handleFavouriteFlow(recipe)
    }

    private fun handleFavouriteFlow(recipe: Recipe?) {
        var isFavorite = false
        recipe?.id?.let {
            viewModel.findRecipeById(recipe.id).observe(this) {
                if (it == null) {
                    Log.d("RecipeDetailsActivity", "in if")
                    binding.addToFavouriteBtn.text = resources.getString(R.string.add_to_favourite)
                    isFavorite = false
                } else {
                    Log.d("RecipeDetailsActivity", "in else")
                    binding.addToFavouriteBtn.text =
                        resources.getString(R.string.remove_from_favourite)
                    isFavorite = true
                }
            }
        }
        binding.addToFavouriteBtn.setOnClickListener {
            if (isFavorite) {
                recipe?.let { it1 -> viewModel.deleteRecipe(it1) }
                binding.addToFavouriteBtn.text = resources.getString(R.string.add_to_favourite)
                isFavorite = false
            } else {
                recipe?.let { it1 -> viewModel.insertRecipe(it1) }
                binding.addToFavouriteBtn.text =
                    resources.getString(R.string.remove_from_favourite)
                isFavorite = true
            }
        }
    }

    private fun getRecipeIngredientsAsString(recipe: Recipe): String {
        var result: String = ""
        for (item in recipe.ingredients) {
            result += "$item, "
        }
        return result
    }
}