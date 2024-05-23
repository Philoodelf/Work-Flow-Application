package com.example.work_flowapplication.ui.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface apiservices {

@POST("api/v1/auth/signIn")
fun userregister(@Body userrequest :LoginRequest ):Call<LoginResponse>


@GET("api/v1/task")
fun getalltask(@Header ("token")token :String? ):Call<Alltaskrespond>


}