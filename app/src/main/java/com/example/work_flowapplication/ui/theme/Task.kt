package com.example.work_flowapplication.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_flowapplication.R
import com.example.work_flowapplication.ui.api.Alltaskrespond
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.ResultItem
import com.example.work_flowapplication.ui.localdata.getToken
import retrofit2.Call
import retrofit2.Response

@Composable
fun app() {


    val context = LocalContext.current.applicationContext
val tasklist= remember{ mutableStateOf<List<ResultItem?>?>(listOf()) }
    val isLoading = remember { mutableStateOf(false) }
getdata(context,tasklist,isLoading)

    Box(modifier = Modifier.fillMaxSize()) {myTask(tasks =tasklist.value )
        ProgressBar(isLoading = isLoading)

    }

    val imageId = arrayOf(
        R.drawable.personimage,
        R.drawable.personimage,
        R.drawable.personimage,
        R.drawable.personimage
    )
    val description = arrayOf(
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum ",
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum ",
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum ",
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum "
    )
    val startDate = arrayOf(
        "18-1-2024",
        "18-1-2024",
        "18-1-2024",
        "18-1-2024"
    )
    val endDate = arrayOf(
        "18-1-2024",
        "18-1-2024",
        "18-1-2024",
        "18-1-2024"
    )

}

@Composable
fun myTask(tasks: List<ResultItem?>?) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray) {
        LazyColumn {
            tasks?.size?.let {
                items(it) {

                    task(task = tasks.get(it))

                }
            }
        }
    }
}
fun getdata(context:Context,taskitemrespondstate:MutableState <List<ResultItem?>?>, isLoading: MutableState<Boolean> ){
    isLoading.value = true

    ApiManger.getapiservices().getalltask(getToken(context)).enqueue(object : retrofit2.Callback<Alltaskrespond> {


        @SuppressLint("SuspiciousIndentation")
        override fun onResponse(p0: Call<Alltaskrespond>, p1: Response<Alltaskrespond>) {
            isLoading.value = false
            val respond = p1.body()
            if (p1.isSuccessful && respond != null) {
      taskitemrespondstate.value=respond?.result


                // Update the state with the API response
                Log.e("tag", "onResponse: message: ${respond.message}")
                Log.e("tag", "onResponse: message: ${respond.result}")
            } else {
                handleApiError(p1)
            }
        }
        override fun onFailure(p0: Call<Alltaskrespond>, p1: Throwable) {
            isLoading.value = false
            Log.e("tag", "onResponse: message: failure")
        }
    }) }
@Composable
fun task(task:ResultItem?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(graycolour)
    ) {
        Card(
            modifier = Modifier
                .width(340.dp)
                .height(200.dp)
                .padding(top = 32.dp, start = 15.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(15.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.padding(top = 13.dp, start = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.personimage),
                        contentDescription = "",
                        modifier = Modifier
                            .size(36.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text =task?.description?:"" ,
                        fontSize = 11.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.padding(start = 20.dp)) {
                    Box(
                        modifier = Modifier
                            .width(91.dp)
                            .height(24.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xFFECEDF1))
                    ) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Icon(
                                painter = painterResource(id =R.drawable.calendaricon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(16.dp)
                                    .padding(top = 4.dp, start = 2.dp), tint = Color.Black
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = task?.startDate?:"",


                                fontSize = 12.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.task_arrow),
                        contentDescription = "",
                        modifier = Modifier
                            .width(25.dp)
                            .height(13.dp)
                            .padding(top = 4.dp, start = 2.dp), tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Box(
                        modifier = Modifier
                            .width(91.dp)
                            .height(24.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xFFECEDF1))
                    ) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Icon(
                                painter = painterResource(id =R.drawable.calendaricon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(16.dp)
                                    .padding(top = 4.dp, start = 2.dp), tint = Color.Black
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = task?.endDate?:"",


                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(
                    onClick = { }, modifier = Modifier
                        .height(32.dp)
                        .width(200.dp)
                        .clip(RoundedCornerShape(1.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
                ) {
                    Text(
                        text = "View", fontSize = 12.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier

                    )
                }
            }
        }
    }
}
fun handleApiError(response: Response<Alltaskrespond>) {
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
fun ProgressBar(isLoading: MutableState<Boolean>) {
    if (isLoading.value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.White
            )
        }
    }
}




@Composable
@Preview
fun taskPreview() {
    app()
}
