package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

data class FeaturesItem(

	@field:SerializedName("site")
	val site: Site? = null,

	@field:SerializedName("featured_on")
	val featuredOn: Int? = null,

	@field:SerializedName("url")
	val url: String? = null
)