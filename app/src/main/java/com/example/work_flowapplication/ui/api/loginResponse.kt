package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("message")
	val message: String? = null
	,

	@field:SerializedName("token")
	val token: String? = null
)
