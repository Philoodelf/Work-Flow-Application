package com.example.work_flowapplication.ui.localdata

import android.content.Context
import android.util.Base64
import android.util.Log
import org.json.JSONObject

private const val PREF_NAME = "com.example.work_flowapplication.ui.theme"
// Define the key for storing the token
private const val TOKEN_KEY = "token"
private const val NAME_KEY = "name"
private const val ROLE_KEY = "role"
private const val CIRCLE_LATITUDE_KEY = "circle_latitude"
private const val CIRCLE_LONGITUDE_KEY = "circle_longitude"
private const val CIRCLE_RADIUS_KEY = "circle_radius"

fun saveToken(context: Context, token: String?) {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(TOKEN_KEY, token)
    editor.apply()
}

fun getToken(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString(TOKEN_KEY, null)
}

fun decodeAndSaveTokenData(context: Context, token: String?) {
    val tokenParts = token?.split('.')
    if (tokenParts?.size == 3) {
        val payload = tokenParts[1]
        val decodedPayload = String(Base64.decode(payload, Base64.DEFAULT))
        val jsonData = JSONObject(decodedPayload)
        val name = jsonData.optString("name")
        val role = jsonData.optString("role")
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(NAME_KEY, name)
        editor.putString(ROLE_KEY, role)
        editor.apply()
        Log.e("tag", "Token data saved: name = $name, role = $role")
    } else {
        Log.e("tag", "Invalid token")
    }
}

fun deleteToken(context: Context) {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.remove(TOKEN_KEY)
    editor.remove(NAME_KEY)
    editor.remove(ROLE_KEY)
    editor.apply()
}

fun getRole(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString(ROLE_KEY, null)
}

fun getName(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString(NAME_KEY, null)
}




// New function to handle receiving a new token and updating the role
fun updateTokenAndRole(context: Context, newToken: String?) {
    // Delete the existing token and associated data
    deleteToken(context)
    // Save the new token
    saveToken(context, newToken)
    // Decode the new token and save the new role
    decodeAndSaveTokenData(context, newToken)
}
fun saveCirclePosition(context: Context, latitude: Double, longitude: Double, radius: Double) {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(CIRCLE_LATITUDE_KEY, latitude.toString())
    editor.putString(CIRCLE_LONGITUDE_KEY, longitude.toString())
    editor.putString(CIRCLE_RADIUS_KEY, radius.toString())
    editor.apply()
}
fun getCirclePosition(context: Context): Triple<Double, Double, Double>? {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val latitude = sharedPreferences.getString(CIRCLE_LATITUDE_KEY, null)?.toDoubleOrNull()
    val longitude = sharedPreferences.getString(CIRCLE_LONGITUDE_KEY, null)?.toDoubleOrNull()
    val radius = sharedPreferences.getString(CIRCLE_RADIUS_KEY, null)?.toDoubleOrNull()

    return if (latitude != null && longitude != null && radius != null) {
        Triple(latitude, longitude, radius)
    } else {
        null
    }
}


class Biometric(private val context: Context) {

    // Shared preferences constants
    private val PREF_NAME = "com.example.work_flowapplication.biometric"
    private val FINGERPRINT_KEY = "fingerprint_data"

    // Function to store fingerprint data
    fun saveFingerprintData(fingerprintData: ByteArray) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(FINGERPRINT_KEY, encodeToString(fingerprintData))
        editor.apply()
    }

    // Function to retrieve fingerprint data
    fun getFingerprintData(): ByteArray? {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val fingerprintString = sharedPreferences.getString(FINGERPRINT_KEY, null)
        return fingerprintString?.let { decodeFromString(it) }
    }

    // Helper functions to encode and decode byte array to string
    private fun encodeToString(byteArray: ByteArray): String {
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    private fun decodeFromString(encodedString: String): ByteArray {
        return Base64.decode(encodedString, Base64.DEFAULT)
    }



}