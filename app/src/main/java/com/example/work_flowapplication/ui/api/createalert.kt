package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class Createalert(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

//	@field:SerializedName("assignedTo")
//	val assignedTo: String? = null
)
