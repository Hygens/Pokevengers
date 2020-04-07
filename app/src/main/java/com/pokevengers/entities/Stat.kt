package com.pokevengers.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Stat : Serializable {
    @SerializedName("name")
    @Expose
    private var name: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("url")
    @Expose
    private var url: String? = null
        get() = field
        set(value) {
            field = value
        }
}