package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class Result(

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("reason")
	val reason: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("file")
	val file: String? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class Vacationrespond(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("message")
	val message: String? = null
)
