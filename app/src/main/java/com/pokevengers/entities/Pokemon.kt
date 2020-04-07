package com.pokevengers.entities

import com.google.gson.annotations.SerializedName

import java.io.Serializable
import java.util.*

class Pokemon : Serializable {
    @SerializedName("name")
    private var name: String? = null

    @SerializedName("stats")
    private var pokestats: MutableList<PokemonStats?>? = ArrayList()
    private val attack: Int? = null
    private val defense: Int? = null
    private val speed: Int? = null
    private val health: Int? = null

    @SerializedName("height")
    private var height: String? = null

    @SerializedName("id")
    var pokedexId: Int? = null

    @SerializedName("weight")
    private var weight: String? = null

    @SerializedName("sprites")
    private var sprites: PokemonRes? = null

    @SerializedName("types")
    private var pokeSlotTypes: MutableList<PokemonSlotType?>? = ArrayList()

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getAttack(): Int? {
        return pokestats?.get(4)?.getBaseStat()
    }

    fun getDefense(): Int? {
        return pokestats?.get(3)?.getBaseStat()
    }

    fun getHeight(): String? {
        return height
    }

    fun setHeight(height: String?) {
        this.height = height
    }

    fun getHealth(): Int? {
        return pokestats?.get(5)?.getBaseStat()
    }

    fun getSpeed(): Int? {
        return pokestats?.get(0)?.getBaseStat()
    }

    fun getWeight(): String? {
        return weight
    }

    fun setWeight(weight: String?) {
        this.weight = weight
    }

    fun getSprites(): PokemonRes? {
        return sprites
    }

    fun setSprites(sprites: PokemonRes?) {
        this.sprites = sprites
    }

    fun getPokeSlotTypes(): MutableList<PokemonSlotType?>? {
        return pokeSlotTypes
    }

    fun setPokeSlotTypes(pokeSlotTypes: MutableList<PokemonSlotType?>?) {
        this.pokeSlotTypes = pokeSlotTypes
    }

    fun getPokeStats(): MutableList<PokemonStats?>? {
        return pokestats
    }

    fun setPokeStats(pokestats: MutableList<PokemonStats?>?) {
        this.pokestats = pokestats
    }

    fun pokemonTypesToString(): String? {
        var types: String? = ""
        for (i in pokeSlotTypes?.indices!!) {
            if (i > 0) types += ", "
            types += pokeSlotTypes?.get(i)?.getPokeType()?.getName()
        }
        return types
    }
}