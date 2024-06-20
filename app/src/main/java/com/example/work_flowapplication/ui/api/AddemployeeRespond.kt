package com.example.work_flowapplication.ui.api

import com.google.gson.annotations.SerializedName

data class AddemployeeRespond(

	@field:SerializedName("add")
	val add: Add? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Add(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("verified")
	val verified: Boolean? = null,

	@field:SerializedName("isActive")
	val isActive: Boolean? = null,

	@field:SerializedName("birthDate")
	val birthDate: String? = null,

	@field:SerializedName("currentLocation")
	val currentLocation: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("social_status")
	val socialStatus: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("fingerPrint")
	val fingerPrint: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
