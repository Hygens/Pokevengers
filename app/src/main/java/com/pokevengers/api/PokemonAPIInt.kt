package com.pokevengers.api

import com.pokevengers.entities.Pokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPIInt {
    @GET("api/v2/pokemon/{id}")
    open fun getPokemon(@Path("id") id: Int): Call<Pokemon?>?

    @GET("api/v2/pokemon/{name}")
    open fun getPokemon(@Path("name") name: String?): Call<Pokemon?>?
}