package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class Logoutrequest(

	@field:SerializedName("email")
	val email: String? = null
)
