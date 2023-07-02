package com.example.recipesapp.ui.recipes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.recipesapp.data.model.Recipe
import com.example.recipesapp.databinding.RecipeItemBinding


class RecipeAdapter(
    private val recipes: List<Recipe>?,
    private val itemClickAction: (recipe: Recipe) -> (Unit),
    private val context: Context,
) :
    Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipes?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        recipes?.get(position)?.let { holder.bind(it) }
        holder.itemBinding.recipeItemView.setOnClickListener {
            recipes?.get(position)?.let { it1 -> itemClickAction(it1) }
        }
        Glide.with(context).load(recipes?.get(position)?.image)
            .into(holder.itemBinding.recipeImage)
    }

    class RecipeViewHolder(val itemBinding: RecipeItemBinding) :
        ViewHolder(itemBinding.root) {
        fun bind(recipe: Recipe) {
            itemBinding.recipeName.text = recipe.name
            itemBinding.recipeHeadline.text = recipe.headline
        }
    }

}