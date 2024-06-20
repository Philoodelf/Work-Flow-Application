package com.example.work_flowapplication

import android.content.Context
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.Employeedatarespond
import com.example.work_flowapplication.ui.api.info
import com.example.work_flowapplication.ui.localdata.getToken
import com.example.work_flowapplication.ui.localdata.saveEmployeeId
import retrofit2.Call
import retrofit2.Response

@Composable
fun Profile() {
    val infolist= remember{ mutableStateOf<List<info?>?>(listOf()) }

    val context = LocalContext.current.applicationContext
    getdate(context,infolist)

profiile(infolist.value)

    }
@Composable
fun profiile(d:List<info?>?){
    val context = LocalContext.current.applicationContext
    val data: info? = d?.firstOrNull()
    if (data != null) {
        saveEmployeeId(context,data.id?:"")
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //profile
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.proprofile),
                    contentDescription = "des",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center)
                        .clip(RoundedCornerShape(16.dp))
                        .padding(start = 15.dp, top = 15.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = { },
                modifier = Modifier.padding(end = 15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "End Icon",
                    modifier = Modifier
                        .size(40.dp) // Adjust the size as needed
                        .padding(end = 15.dp,)
                )
            }
        }
        Column(modifier = Modifier) {

            //name

            Text(
                text = "Name",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
            )
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F6FA),
                ),
                border = BorderStroke(0.8.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(40.dp)
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                if (data != null) {
                    Text(
                        text = data.name?:"",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 7.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
            }



            //Email


            Text(
                text = "Email",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
            )
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F6FA),
                ),
                border = BorderStroke(0.8.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(40.dp)
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                if (data != null) {
                    Text(
                        text = data.email?:"",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 7.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black

                    )
                }
            }

            //Phone

            Text(
                text = "Phone",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
            )
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F6FA),
                ),
                border = BorderStroke(0.8.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(40.dp)
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                if (data != null) {
                    Text(
                        text = data.phone?:"",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 7.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black

                    )
                }
            }

            //address

            Text(
                text = "Address",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
            )
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F6FA),
                ),
                border = BorderStroke(0.8.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                if (data != null) {
                    Text(
                        text = data.address?:"",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 4.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black

                    )
                }
            }

            //Gender

            Row() {
                Text(
                    text = "Gender",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp,)
                )
                Text(
                    text = "Birth Date",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 100.dp, top = 20.dp,)
                )

            }

            Row(modifier = Modifier.padding(start = 16.dp)) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF029DF0),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(15.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )

                if (data != null) {
                    Text(
                        text =data.gender?:"", fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 8.dp,),
            //                    textAlign = TextAlign.Center,
                    )
                }

                if (data != null) {
                    Text(
                        text = data.birthDate?:"", fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(start = 100.dp,),
                    )
                }


            }


        }

    }







}

fun getdate(context:Context,profileitemrespondstate: MutableState<List<info?>?>){
    ApiManger.getapiservices().getemployeebyname("esmail", getToken(context)).enqueue(object :retrofit2.Callback<Employeedatarespond>{
        override fun onResponse(p0: Call< Employeedatarespond>, p1: Response< Employeedatarespond>) {
            val rspond = p1.body()
            if (p1.isSuccessful && rspond != null) {

                profileitemrespondstate.value=rspond?.result

                Log.e("tag", "onResponse: message: ${rspond.message}")


                Log.e("tag", "onResponse: message: ${rspond.result}")
            }
            else {
                hndelerror(p1)
            }
        }
        private fun hndelerror(response:Response< Employeedatarespond>) {
            when (response.code()) {
                401 -> {
                    // Handle Unauthorized - token may be invalid or expired
                    Log.e("tag", "onResponse: unauthorized, token might be expired or invalid")
                    // You can prompt the user to login again or refresh the token
                }
                429 -> {
                    // Handle Too Many Requests - rate limiting
                    Log.e("tag", "onResponse: too many requests, retry after some time")
                    // You can implement a retry mechanism with exponential backoff
                }
                400 -> {
                    // Handle Bad Request
                    val errorBody = response.errorBody()?.string()
                    Log.e("tag", "onResponse: bad request, error: $errorBody")
                }
                500 -> {
                    // Handle Internal Server Error
                    val errorBody = response.errorBody()?.string()
                    Log.e("tag", "onResponse: server error, error: $errorBody")
                }
                else -> {
                    // Handle other status codes
                    val errorBody = response.errorBody()?.string()
                    Log.e("tag", "onResponse: error, code: ${response.code()}, error: $errorBody")
                }
            }
        }

        override fun onFailure(p0: Call< Employeedatarespond>, p1: Throwable) {



        }
    })






}
