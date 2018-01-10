package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

data class ColorsItem(

        @field:SerializedName("r")
        val R: Double? = null,

        @field:SerializedName("b")
        val B: Double? = null,

        @field:SerializedName("s")
        val S: Double? = null,

        @field:SerializedName("v")
        val V: Double? = null,

        @field:SerializedName("g")
        val G: Double? = null,

        @field:SerializedName("h")
        val H: Double? = null
)