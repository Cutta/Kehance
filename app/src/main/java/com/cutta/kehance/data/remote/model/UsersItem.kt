package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class UsersItem(

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("first_name")
        val firstName: String,

        @field:SerializedName("last_name")
        val lastName: String,

        @field:SerializedName("username")
        val username: String,

        @field:SerializedName("city")
        val city: String,

        @field:SerializedName("state")
        val state: String? = null,

        @field:SerializedName("country")
        val country: String? = null,

        @field:SerializedName("location")
        val location: String? = null,

        @field:SerializedName("company")
        val company: String? = null,

        @field:SerializedName("occupation")
        val occupation: String? = null,

        @field:SerializedName("created_on")
        val createdOn: Int? = null,

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("images")
        val images: Images,

        @field:SerializedName("display_name")
        val displayName: String,

        @field:SerializedName("fields")
        val fields: List<String>? = null,

        @field:SerializedName("has_default_image")
        val hasDefaultImage: Int? = null,

        @field:SerializedName("website")
        val website: String? = null,

        @field:SerializedName("stats")
        val stats: Stats,

        @field:SerializedName("twitter")
        val twitter: String? = null


)