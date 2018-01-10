package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

data class Covers(

	@field:SerializedName("original")
	val original: String? = null,

	@field:SerializedName("202")
	val jsonMember202: String? = null,

	@field:SerializedName("115")
	val jsonMember115: String? = null,

	@field:SerializedName("404")
	val jsonMember404: String? = null,

	@field:SerializedName("230")
	val jsonMember230: String? = null
)