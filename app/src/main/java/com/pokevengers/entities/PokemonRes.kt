package com.pokevengers.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class PokemonRes : Serializable {
    @SerializedName("back_default")
    @Expose
    private var backDefault: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("back_female")
    @Expose
    private var backFemale: Any? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("back_shiny")
    @Expose
    private var backShiny: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("back_shiny_female")
    @Expose
    private var backShinyFemale: Any? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("front_default")
    @Expose
    var frontDefault: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("front_female")
    @Expose
    private var frontFemale: Any? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("front_shiny")
    @Expose
    private var frontShiny: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("front_shiny_female")
    @Expose
    private var frontShinyFemale: Any? = null
        get() = field
        set(value) {
            field = value
        }
}