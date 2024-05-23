package com.example.work_flowapplication.ui.localdata
import android.content.Context
import android.util.Base64
import android.util.Log
import org.json.JSONObject
private const val PREF_NAME = "com.example.work_flowapplication.ui.theme"
// Define the key for storing the token
private const val TOKEN_KEY = "token"
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
private val FINGERPRINT_KEY = "fingerprint_data"
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
        editor.putString("name", name)
        editor.putString("role", role)
        editor.apply()
        Log.e("tag", " token:name${name}")
        Log.e("tag", " token: role:${role}")


    }
else{
        Log.e("tag", " token: invalidtoken")
}}

fun deleteToken(context: Context) {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.remove(TOKEN_KEY)
    editor.apply()
}
fun getRole(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString("role", null)
}
fun getName(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString("name", null)
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