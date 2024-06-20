package com.example.work_flowapplication.ui.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiManger private constructor(){
companion object {
    val client = OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS) // Adjust timeout value as needed
        .readTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .build()


    private var INSTANCE : Retrofit ? =null
    private fun getinstance ():Retrofit{
    if(INSTANCE==null)
   INSTANCE =Retrofit.Builder().baseUrl(" https://workflow-api-v1.onrender.com/").client(client)
    .addConverterFactory(GsonConverterFactory.create()).build()

return INSTANCE!!

    }
    fun getapiservices ():apiservices{
        return getinstance().create(apiservices::class.java)

    }








}



}