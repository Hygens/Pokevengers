package com.pokevengers.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonAPI {
    val BASE_URL: String? = "https://pokeapi.co/"
    private var retrofit: Retrofit? = null
    fun getAPIClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }
}