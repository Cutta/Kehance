package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Copyright(

	@field:SerializedName("license")
	val license: String? = null,

	@field:SerializedName("license_id")
	val licenseId: Int? = null,

	@field:SerializedName("description")
	val description: String? = null
)