package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Project(

	@field:SerializedName("copyright")
	val copyright: Copyright? = null,

	@field:SerializedName("editor_version")
	val editorVersion: Int? = null,

	@field:SerializedName("privacy")
	val privacy: String? = null,

	@field:SerializedName("mature_access")
	val matureAccess: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("owners")
	val owners: List<OwnersItem>,

	@field:SerializedName("tools")
	val tools: List<ToolsItem>? = null,

	@field:SerializedName("conceived_on")
	val conceivedOn: Int? = null,

	@field:SerializedName("short_url")
	val shortUrl: String? = null,

	@field:SerializedName("mature_content")
	val matureContent: Int? = null,

	@field:SerializedName("features")
	val features: List<FeaturesItem>? = null,

	@field:SerializedName("canvas_width")
	val canvasWidth: Int? = null,

	@field:SerializedName("stats")
	val stats: Stats,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("covers")
	val covers: Covers? = null,

	@field:SerializedName("modified_on")
	val modifiedOn: Int? = null,

	@field:SerializedName("allow_comments")
	val allowComments: Int? = null,

	@field:SerializedName("published_on")
	val publishedOn: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("modules")
	val modules: List<ModulesItem>? = null,

	@field:SerializedName("tags")
	val tags: List<String>?,

	@field:SerializedName("created_on")
	val createdOn: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("creator_id")
	val creatorId: Int? = null,

	@field:SerializedName("styles")
	val styles: Styles? = null,

	@field:SerializedName("fields")
	val fields: List<String>
)