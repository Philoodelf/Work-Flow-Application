package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class Sendtaskrequest(

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("assignTo")
	val assignTo: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
