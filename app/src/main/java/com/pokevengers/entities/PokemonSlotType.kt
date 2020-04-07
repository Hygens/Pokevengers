package com.pokevengers.entities

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class PokemonSlotType : Serializable {
    @SerializedName("slot")
    private var slot: Int? = null

    @SerializedName("type")
    private var pokeType: PokemonType? = null

    fun getSlot(): Int? {
        return slot
    }

    fun setSlot(slot: Int?) {
        this.slot = slot
    }

    fun getPokeType(): PokemonType? {
        return pokeType
    }

    fun setPokeType(pokeType: PokemonType?) {
        this.pokeType = pokeType
    }
}