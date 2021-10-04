package com.example.il3sample.retrofit.api

import com.example.il3sample.commons.model.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/recipes")
    fun getRecipes(): Call<Recipes>
}

