package com.example.il3sample.commons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.il3sample.databinding.ItemRecipeBinding
import com.example.il3sample.commons.model.Recipe

class RecipeAdapter(private val recipes: List<Recipe>): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder (val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        with(holder.binding){
            tvTitle.text = recipe.title
            tvTimes.text= recipe.times
            Glide.with(this.root.context).load(recipe.thumb).into(ivRecipe)
        }
    }

    override fun getItemCount() = recipes.size
}