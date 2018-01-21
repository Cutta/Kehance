package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProjectItem(

        @field:SerializedName("modified_on")
        val modifiedOn: Int,

        @field:SerializedName("published_on")
        val publishedOn: Int,

        @field:SerializedName("privacy")
        val privacy: String,

        @field:SerializedName("mature_access")
        val matureAccess: String,

        @field:SerializedName("owners")
        val owners: List<UsersItem>,

        @field:SerializedName("url")
        val url: String,

        @field:SerializedName("colors")
        val colors: List<ColorsItem>,

        @field:SerializedName("conceived_on")
        val conceivedOn: Int,

        @field:SerializedName("mature_content")
        val matureContent: Int,

        @field:SerializedName("features")
        val features: List<FeaturesItem>,

        @field:SerializedName("created_on")
        val createdOn: Int,

        @field:SerializedName("stats")
        val stats: Stats,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("fields")
        val fields: List<String>,

        @field:SerializedName("covers")
        val covers: Covers
)