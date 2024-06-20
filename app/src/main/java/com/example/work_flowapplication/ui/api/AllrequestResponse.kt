package com.example.work_flowapplication.ui.api

import com.google.gson.*
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

class ImageDeserializer : JsonDeserializer<iimage?> {
	override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): iimage? {
		return if (json.isJsonObject) {
			context.deserialize(json, iimage::class.java)
		} else if (json.isJsonPrimitive && json.asJsonPrimitive.isString) {
			iimage(secureUrl = json.asString, publicId = "")
		} else {
			null
		}
	}
}
val gson: Gson = GsonBuilder()
	.registerTypeAdapter(iimage::class.java, ImageDeserializer())
	.create()
data class AllrequestResponse(

	@field:SerializedName("result")
	val result: List<items?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class iimage(

	@field:SerializedName("secure_url")
	val secureUrl: String? = null,

	@field:SerializedName("public_id")
	val publicId: String? = null
)

data class items(

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("owner")
	val owner: Owner? = null,

	@field:SerializedName("reason")
	val reason: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("image")
	val image: iimage? = null
)

data class Owner(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null
)
