package com.example.work_flowapplication

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_flowapplication.ui.api.AllrequestResponse
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.items
import com.example.work_flowapplication.ui.theme.graycolour
import retrofit2.Call
import retrofit2.Response

@Composable
fun Request() {
    val requestlist= remember{ mutableStateOf<List<items?>?>(listOf()) }
    getdata(requestlist)
myrequest(requests = requestlist.value)




}

@Composable
fun myrequest(requests:List<items?>?){
    Box(modifier=Modifier.background(graycolour) ){
        LazyColumn{
            requests?.size?.let {
                items(it) {

                    requests.get(it)?.let { it1 -> requestcard(request = it1) }

                }
            }


            }
        }}




fun getdata(responditemrespondstate: MutableState<List<items?>?>){
    ApiManger.getapiservices().getallrequest().enqueue(object : retrofit2.Callback<AllrequestResponse> {
        @SuppressLint("SuspiciousIndentation")
        override fun onResponse(p0: Call<AllrequestResponse>, p1: Response<AllrequestResponse>) {
            val respond = p1.body()
            if (p1.isSuccessful && respond != null) {
                responditemrespondstate.value=respond?.result
                // Update the state with the API response
                Log.e("tag", "onResponse: message: ${respond.message}")
                Log.e("tag", "onResponse: message: ${respond.result}")
            } else {
               haandleApiError(p1)
            }
        }
        override fun onFailure(p0: Call<AllrequestResponse>, p1: Throwable) {


            Log.e("tag", "onFailure: message: ${p1
                .message}", p1)
        }
    })

}

    fun haandleApiError(response: Response<AllrequestResponse>) {
        when (response.code()) {
            401 -> {
                Log.e("tag", "onResponse: unauthorized, token might be expired or invalid")
            }
            429 -> {
                Log.e("tag", "onResponse: too many requests, retry after some time")
            }
            400 -> {
                val errorBody = response.errorBody()?.string()
                Log.e("tag", "onResponse: bad request, error: $errorBody")
            }
            500 -> {
                val errorBody = response.errorBody()?.string()
                Log.e("tag", "onResponse: server error, error: $errorBody")
            }
            else -> {
                val errorBody = response.errorBody()?.string()
                Log.e("tag", "onResponse: error, code: ${response.code()}, error: $errorBody")
            }
        }
    }

@Composable
fun requestcard(request:items){
    ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .size(width = 380.dp, height = 150.dp)
            .padding(start = 20.dp, top = 16.dp)
            .clickable { "to do" },
        colors = CardDefaults.cardColors(Color.White)) {
        //image + name + job
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.requestprofile),
                contentDescription = "des",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(start = 15.dp, top = 15.dp)
            )
            Column(modifier = Modifier.padding(15.dp)) {
                Text(request.owner?.name ?:"", fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Text(request.id?:"", fontSize = 10.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier.padding(end = 16.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Box(modifier = Modifier
                    .padding(end = 38.dp, top = 4.dp)
                    .clickable { }) {

                    Image(
                        painter = painterResource(id = R.drawable.correcticon),
                        contentDescription = "des",
                        modifier = Modifier
                            .size(46.dp)
                            .padding(8.dp)
                    )

                }
                Box(modifier = Modifier.clickable {  }) {
                    Image(
                        painter = painterResource(id = R.drawable.xicon),
                        contentDescription = "des",
                        modifier = Modifier
                            .size(52.dp)
                            .padding(8.dp)
                    )
                }


            }
        }
        // date + time + info
        Column {
            Row(modifier = Modifier.padding(start = 25.dp, top = 5.dp)) {
                Icon(
                    Icons.Rounded.DateRange,
                    contentDescription = "icon",
                    tint = Color(0xFF029DF0),
                    modifier = Modifier.size(15.dp)
                )
                Text(request.startDate?:"", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                Text("to", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                Text(request.endDate?:"", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)

            }

            Row(modifier = Modifier.padding(start = 24.dp, top = 5.dp)) {
                Icon(
                    Icons.Rounded.List,
                    contentDescription = "icon",
                    tint = Color(0xFF029DF0),
                    modifier = Modifier.size(18.dp)
                )
                Text(request.reason?:"", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)

            }
        }
        // info
        Row(modifier = Modifier.padding(start = 25.dp, top = 5.dp)
        ) {
            Card(
                modifier = Modifier
                    .size(width = 53.dp, height = 21.dp)
                    .padding(bottom = 2.dp)
                    .wrapContentWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color(0xFFECEDF1))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Dummydata",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
/*
            if (info2.isNotBlank()){
                Card(
                    modifier = Modifier
                        .size(width = 62.dp, height = 21.dp)
                        .padding(start = 10.dp, bottom = 2.dp)
                        .wrapContentWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(Color(0xFFECEDF1))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = info2,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
*/
        }


    }






}
