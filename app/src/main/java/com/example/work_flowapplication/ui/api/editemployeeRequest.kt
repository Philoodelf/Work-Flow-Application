package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class EditemployeeRequest(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("social_status")
	val socialStatus: String? = null,

	@field:SerializedName("birthDate")
	val birthDate: String? = null,

	@field:SerializedName("fingerPrint")
	val fingerPrint: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
