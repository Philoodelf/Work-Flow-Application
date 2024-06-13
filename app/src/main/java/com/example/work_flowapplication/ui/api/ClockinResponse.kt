package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class ClockinResponse(

	@field:SerializedName("record")
	val record:  ClockinRecord? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ClockinRecord(

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("clockIn")
	val clockIn: String? = null
)
