package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Subtitle(

	@field:SerializedName("font_weight")
	val fontWeight: String? = null,

	@field:SerializedName("text_decoration")
	val textDecoration: String? = null,

	@field:SerializedName("line_height")
	val lineHeight: String? = null,

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("font_size")
	val fontSize: String? = null,

	@field:SerializedName("display")
	val display: String? = null,

	@field:SerializedName("font_family")
	val fontFamily: String? = null,

	@field:SerializedName("font_style")
	val fontStyle: String? = null,

	@field:SerializedName("text_transform")
	val textTransform: String? = null,

	@field:SerializedName("text_align")
	val textAlign: String? = null
)