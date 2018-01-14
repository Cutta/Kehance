package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class ToolsItem(

	@field:SerializedName("synonym")
	val synonym: Any? = null,

	@field:SerializedName("approved")
	val approved: String? = null,

	@field:SerializedName("category_label")
	val categoryLabel: String? = null,

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)