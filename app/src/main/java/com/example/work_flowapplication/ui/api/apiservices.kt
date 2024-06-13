package com.example.work_flowapplication.ui.api

import com.example.work_flowapplication.ui.localdata.getToken
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface apiservices {

@POST("api/v1/auth/signIn")
fun userregister(@Body userrequest :LoginRequest ):Call<LoginResponse>


@GET("api/v1/task")
fun getalltask(@Header ("token")token :String? ):Call<Alltaskrespond>


@POST("api/v1/alert")
fun createalert(@Header("token")token :String?, @Body alert: Createalert):Call<Alertrespond>


@GET("api/v1/employee?name")
fun searchn(@Query("name")name: String?):Call<Searchname>
}



