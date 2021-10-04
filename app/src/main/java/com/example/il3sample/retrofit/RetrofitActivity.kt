package com.example.il3sample.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.il3sample.commons.RecipeAdapter
import com.example.il3sample.databinding.ActivityRecipesBinding
import com.example.il3sample.retrofit.api.ApiConfig
import com.example.il3sample.commons.model.Recipe
import com.example.il3sample.commons.model.Recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecipesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRecipes()
    }

    private fun getRecipes() {
        val client = ApiConfig.getApiService().getRecipes()
        client.enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                response.body()?.let {
                    showRecipes(it.results)
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                println("data gagal didapatkan, error $t")
            }

        })
    }

    fun showRecipes(recipes: List<Recipe>){
        val adapter = RecipeAdapter(recipes)
        binding.rvRecipe.layoutManager = LinearLayoutManager(this)
        binding.rvRecipe.adapter = adapter
    }
}