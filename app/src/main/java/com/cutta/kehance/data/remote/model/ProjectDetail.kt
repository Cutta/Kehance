package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class ProjectDetail(

	@field:SerializedName("http_code")
	val httpCode: Int,

	@field:SerializedName("project")
	val project: Project
)