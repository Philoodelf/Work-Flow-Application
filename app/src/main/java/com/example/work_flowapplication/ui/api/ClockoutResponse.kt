package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class ClockoutResponse(

	@field:SerializedName("record")
	val record: Record? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Record(

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("clockOut")
	val clockOut: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("clockIn")
	val clockIn: String? = null,

	@field:SerializedName("workingHours")
	val workingHours: String? = null
)
