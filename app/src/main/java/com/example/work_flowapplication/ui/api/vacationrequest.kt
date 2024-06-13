package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class Vacationrequest(

	@field:SerializedName("reason")
	val reason: String? = null,

	@field:SerializedName("file")
	val file: String? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)