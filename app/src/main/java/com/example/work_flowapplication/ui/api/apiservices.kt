package com.example.work_flowapplication.ui.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query

interface apiservices {

@POST("api/v1/auth/signIn")
fun userregister(@Body userrequest :LoginRequest ):Call<LoginResponse>


@GET("api/v1/task")
fun getalltask(@Header ("token")token :String? ):Call<Alltaskrespond>

@POST("api/v1/workRecord/clockIn")
fun clockin(@Header("token")token:String?):Call<ClockinResponse>

@POST("api/v1/workRecord/clockOut")
fun clockout(@Header("token")token:String?):Call<ClockoutResponse>
@POST("api/v1/request")
fun createvacation(@Header("token")token:String?,@Body vacationreques:Vacationrequest):Call<Vacationrespond>


@POST("/api/v1/task")
fun creatretask(@Header("token")token:String?,@Body sendtaskrequest: Sendtaskrequest):Call<Sendtaskrespond>

@POST("api/v1/alert")
fun createalert(@Header("token")token :String?, @Body alert: Createalert):Call<Alertrespond>


@GET("api/v1/employee?name")
fun searchn(@Query("name")name: String?):Call<Searchname>

@GET("api/v1/request")
fun getallrequest():Call< AllrequestResponse>

@POST("api/v1/auth/logOut")
fun logout(@Body email:Logoutrequest):Call<Logoutrespond>


    @Multipart
    @POST("api/v1/employee")
    fun addEmployee(
        @Header("token") token: String?,
        @Part image: MultipartBody.Part?,
        @PartMap data: Map<String, @JvmSuppressWildcards RequestBody>
    ): Call<AddemployeeRespond>
@GET("api/v1/employee")
fun getemployeebyname(@Query("name") name: String?, @Header("token") token: String?):Call<Employeedatarespond>

@PUT("api/v1/employee/{id}")
fun editemployee(@Path("id") id: String?,@Header("token")token:String?,@Body data:EditemployeeRequest):Call<Editemployeerespond>

@GET("api/v1/workRecord")
fun getworkrecord(@Header("token")token:String?,@Query("_id")id: String?)



}



