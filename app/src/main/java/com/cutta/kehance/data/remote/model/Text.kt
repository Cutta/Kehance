package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Text(

	@field:SerializedName("paragraph")
	val paragraph: Paragraph? = null,

	@field:SerializedName("subtitle")
	val subtitle: Subtitle? = null,

	@field:SerializedName("link")
	val link: Link? = null,

	@field:SerializedName("caption")
	val caption: Caption? = null,

	@field:SerializedName("title")
	val title: Title? = null
)