package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Ribbon(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("image_2x")
	val image2x: String? = null
)