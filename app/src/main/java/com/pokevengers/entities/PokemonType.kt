package com.pokevengers.entities


import com.google.gson.annotations.SerializedName

import java.io.Serializable

class PokemonType() : Serializable {

    @SerializedName("name")
    private var name: String? = null


    @SerializedName("url")
    private var url: String? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

}