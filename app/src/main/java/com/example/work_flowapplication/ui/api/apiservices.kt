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

@POST("api/v1/workRecord/clockIn")
fun clockin(@Header("token")token:String?):Call<ClockinResponse>

@POST("api/v1/workRecord/clockOut")
fun clockout(@Header("token")token:String?):Call<ClockoutResponse>

/*
@POST("api/v1/employee?name=michael")
fun getemployeebyname(@Query("name")name:String?):Call<EmployeedataResponse>
*/
@POST("api/v1/request")
fun createvacation(@Header("token")token:String?,@Body vacationreques:Vacationrequest):Call<Vacationrespond>


@POST("/api/v1/task")
fun creatretask(@Header("token")token:String?,@Body sendtaskrequest: Sendtaskrequest):Call<Sendtaskrespond>

}