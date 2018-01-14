package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Styles(

	@field:SerializedName("spacing")
	val spacing: Spacing? = null,

	@field:SerializedName("background")
	val background: Background? = null,

	@field:SerializedName("text")
	val text: Text? = null,

	@field:SerializedName("dividers")
	val dividers: Dividers? = null
)