package com.cutta.kehance.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProjectList(

		@field:SerializedName("projects")
	val projects: List<ProjectItem?>? = null,

		@field:SerializedName("http_code")
	val httpCode: Int? = null
)