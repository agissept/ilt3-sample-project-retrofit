package com.example.il3sample.retrofitwithcoroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.il3sample.commons.RecipeAdapter
import com.example.il3sample.databinding.ActivityRecipesBinding
import com.example.il3sample.commons.model.Recipe
import com.example.il3sample.retrofitwithcoroutine.api.ApiConfig
import kotlinx.coroutines.*

class RetrofitWithCoroutineActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecipesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        CoroutineScope(Dispatchers.IO).launch {
            getRecipes()
        }
    }

    private suspend fun getRecipes() {
        val response = ApiConfig.getApiService().getRecipes()
        val results = response.results
        runOnUiThread {
            showRecipes(results)
        }
    }

    private fun showRecipes(recipes: List<Recipe>) {
        val adapter = RecipeAdapter(recipes)
        binding.rvRecipe.layoutManager = LinearLayoutManager(this)
        binding.rvRecipe.adapter = adapter
    }
}