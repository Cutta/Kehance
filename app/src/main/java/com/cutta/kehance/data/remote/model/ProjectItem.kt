package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProjectItem(

        @field:SerializedName("modified_on")
        val modifiedOn: Int? = null,

        @field:SerializedName("published_on")
        val publishedOn: Int? = null,

        @field:SerializedName("privacy")
        val privacy: String? = null,

        @field:SerializedName("mature_access")
        val matureAccess: String? = null,

        @field:SerializedName("owners")
        val owners: List<OwnersItem>? = null,

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("colors")
        val colors: List<ColorsItem>? = null,

        @field:SerializedName("conceived_on")
        val conceivedOn: Int? = null,

        @field:SerializedName("mature_content")
        val matureContent: Int? = null,

        @field:SerializedName("features")
        val features: List<FeaturesItem>? = null,

        @field:SerializedName("created_on")
        val createdOn: Int? = null,

        @field:SerializedName("stats")
        val stats: Stats? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("fields")
        val fields: List<String>? = null,

        @field:SerializedName("covers")
        val covers: Covers? = null
)