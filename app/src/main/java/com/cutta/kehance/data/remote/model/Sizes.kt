package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName


data class Sizes(

	@field:SerializedName("max_1920")
	val max1920: String,

	@field:SerializedName("original")
	val original: String,

	@field:SerializedName("1400")
	val jsonMember1400: String,

	@field:SerializedName("max_1240")
	val max1240: String,

	@field:SerializedName("disp")
	val disp: String,

	@field:SerializedName("max_1200")
	val max1200: String? = null
)