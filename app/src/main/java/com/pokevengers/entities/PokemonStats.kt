package com.pokevengers.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class PokemonStats : Serializable {
    @SerializedName("base_stat")
    @Expose
    private var baseStat: Int? = null

    @SerializedName("effort")
    @Expose
    private var effort: Int? = null

    @SerializedName("stat")
    @Expose
    private var stat: Stat? = null
    fun getBaseStat(): Int? {
        return baseStat
    }

    fun setBaseStat(baseStat: Int?) {
        this.baseStat = baseStat
    }

    fun getEffort(): Int? {
        return effort
    }

    fun setEffort(effort: Int?) {
        this.effort = effort
    }

    fun getStat(): Stat? {
        return stat
    }

    fun setStat(stat: Stat?) {
        this.stat = stat
    }
}