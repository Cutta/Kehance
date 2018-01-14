package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Spacing(

	@field:SerializedName("project")
	val project: Project? = null,

	@field:SerializedName("modules")
	val modules: Modules? = null
)