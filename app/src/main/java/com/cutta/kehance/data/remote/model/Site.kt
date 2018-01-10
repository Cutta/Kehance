package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

data class Site(

	@field:SerializedName("domain")
	val domain: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("ribbon")
	val ribbon: Ribbon? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)