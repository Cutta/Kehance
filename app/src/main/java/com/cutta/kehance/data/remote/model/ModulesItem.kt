package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class ModulesItem(

        @field:SerializedName("project_id")
        val projectId: Int? = null,

        @field:SerializedName("full_bleed")
        val fullBleed: Int? = null,

        @field:SerializedName("caption_alignment")
        val captionAlignment: String? = null,

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("type")
        val type: String,

        @field:SerializedName("alignment")
        val alignment: String? = null,


        //TEXT
        @field:SerializedName("text")
        val text: String,

        @field:SerializedName("text_plain")
        val textPlain: String? = null,


        //IMAGE
        @field:SerializedName("src")
        val src: String,

        @field:SerializedName("sizes")
        val sizes: Sizes,

        @field:SerializedName("dimensions")
        val dimensions: Dimensions,

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int,


        //EMBED
        @field:SerializedName("embed")
        val embed: String,

        @field:SerializedName("original_embed")
        val originalEmbed: String,

        @field:SerializedName("original_width")
        val originalWidth: Int,

        @field:SerializedName("original_height")
        val originalHeight: Int,

        @field:SerializedName("width_unit")
        val widthUnit: String)

