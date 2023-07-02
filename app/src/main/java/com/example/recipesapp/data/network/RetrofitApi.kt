package com.example.recipesapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {

    companion object {

        val baseUrl = "https://api.npoint.io"
        private var retrofit: Retrofit? = null

        @JvmStatic
        fun getInstance(): RecipesApi {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(RecipesApi::class.java)
        }
    }


}