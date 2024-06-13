package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class Alertrespond(



	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("result")
	val result: Result? = null,
)

data class Result(

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,



//	@field:SerializedName("assignedTo")
//	val assignedTo: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
