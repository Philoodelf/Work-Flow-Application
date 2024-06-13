package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class AssignTo(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Alltaskrespond(

	@field:SerializedName("result")
	val result: List<ResultSearch?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ResultItem(

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("assignTo")
	val assignTo: AssignTo? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
