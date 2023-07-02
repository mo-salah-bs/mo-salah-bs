package com.example.recipesapp.ui.recipes

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.recipesapp.data.model.Recipe
import com.example.recipesapp.data.repo.IRepository
import com.example.recipesapp.data.repo.Repository
import com.example.recipesapp.databinding.ActivityRecipesBinding
import com.example.recipesapp.ui.recipes_details.RecipeDetailsActivity
import com.example.recipesapp.utils.Constant
import com.example.recipesapp.utils.hide
import com.example.recipesapp.utils.show
import com.example.recipesapp.utils.vertical

class RecipesActivity : AppCompatActivity() {

    private val repository: IRepository by lazy {
        Repository.getInstance(this)
    }
    private val viewModel: RecipeViewModel by lazy {
        ViewModelProvider(this, RecipeViewModelFactory(repository))[RecipeViewModel::class.java]
    }
    private val binding: ActivityRecipesBinding by lazy {
        ActivityRecipesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        initUI()
    }

    private fun initUI() {
        viewModel.recipes.observe(this) {
            binding.loading.hide()
            binding.recipesRecyclerView.show()
            initRecipesRecyclerView(it)
        }
    }

    private fun initRecipesRecyclerView(recipes: List<Recipe>) {
        binding.recipesRecyclerView.vertical(this)
        binding.recipesRecyclerView.adapter = RecipeAdapter(recipes, ::itemClickAction, this)
    }

    private fun itemClickAction(recipe: Recipe) {
        val intent = Intent(this, RecipeDetailsActivity::class.java)
        intent.putExtra(Constant.SELECTED_RECIPE.name, recipe)
        startActivity(intent)
    }
}