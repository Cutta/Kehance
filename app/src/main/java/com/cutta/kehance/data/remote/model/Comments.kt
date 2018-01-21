package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by CuneytCarikci on 19/01/2018.
 */


data class Comments(
        @field:SerializedName("comments")
        val comments: List<CommentItem>? = null
)

data class CommentItem(
        @field:SerializedName("id")
        val id: Int,
        @field:SerializedName("comment")
        val comment: String,

        @field:SerializedName("created_on")
        val createdOn: Double,

        @field:SerializedName("user")
        val user: UsersItem
)