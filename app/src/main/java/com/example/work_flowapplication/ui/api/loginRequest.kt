package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class LoginRequest(
	@field:SerializedName("email")
	val email: String? = null
	,

	@field:SerializedName("password")
	val password: String? = null


)
