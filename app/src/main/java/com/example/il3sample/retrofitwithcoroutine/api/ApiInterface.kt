package com.example.il3sample.retrofitwithcoroutine.api

import com.example.il3sample.commons.model.Recipes
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/recipes")
    suspend fun getRecipes(): Recipes
}