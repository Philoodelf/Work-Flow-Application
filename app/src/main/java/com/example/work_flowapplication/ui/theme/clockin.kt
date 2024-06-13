package com.example.work_flowapplication.ui.theme

import BiometricManage
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.example.work_flowapplication.R
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.ClockinResponse
import com.example.work_flowapplication.ui.api.ClockoutResponse
import com.example.work_flowapplication.ui.localdata.getToken
import com.example.work_flowapplication.ui.location.locationservies.LocationService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import retrofit2.Call
import retrofit2.Response

@Composable
fun clockin(context: AppCompatActivity) {
    val biometricManage = BiometricManage()
    val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    val myState = remember { mutableStateOf("CLOCK IN") }
    val brushColors = listOf(
        Brush.verticalGradient(listOf(Color(0xFF3893E4), Color(0xFF94C4F2))),
        Brush.verticalGradient(listOf(Color(0xFFD3455B), Color(0xFF918FDB)))
    )
    val brushColorIndex = remember { mutableStateOf(0) }

    val centerLat = 31.2318399  // Example latitude for the center of the circular area
    val centerLong = 30.0817835  // Example longitude for the center of the circular area
    val radiusOfCircle = 100.0  // Radius in meters

    Column(
        modifier = Modifier
            .background(lightgray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome ! Ahmed",
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 49.dp),
            color = bluecolour
        )
        Box(
            modifier = Modifier
                .size(250.dp)
                .padding(top = 44.dp)
                .aspectRatio(1f)
                .background(
                    brushColors[brushColorIndex.value], shape = CircleShape
                )
                .clickable {
                    if (myState.value == "CLOCK IN") {
                        biometricManage.authenticateWithBiometrics(context) {
                            if (ActivityCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.ACCESS_FINE_LOCATION
                                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.ACCESS_COARSE_LOCATION
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {


                            }
                            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                                if (location != null && isLocationInsideCircle(location.latitude, location.longitude, centerLat, centerLong, radiusOfCircle)) {
                                    Intent(context, LocationService::class.java).apply {
                                        action = LocationService.ACTION_START
                                        context.startService(this)
                                    }
                                    ApiManger.getapiservices().clockin(getToken(context)).enqueue(object :retrofit2.Callback<ClockinResponse>{
                                        override fun onResponse(
                                            p0: Call<ClockinResponse>,
                                            p1: Response<ClockinResponse>
                                        ) {
                                            val body = p1.body()
                                            if (p1.isSuccessful && body != null) {
                                                Log.e(
                                                    "tag",
                                                    "onResponse: clockin, message: ${body.message}"
                                                )
                                                Log.e(
                                                    "tag",
                                                    "onResponse: clockin, record: ${body.record}"
                                                )

                                            }


                                        }

                                        override fun onFailure(
                                            p0: Call<ClockinResponse>,
                                            p1: Throwable
                                        ) {
                                            Log.e(
                                                "tag",
                                                "onResponse: clockin  not work , token: "
                                            )

                                        }
                                    })
                                    myState.value = "CLOCK OUT"
                                    brushColorIndex.value = 1
                                } else {
                                    showToast(context, "You are not inside the allowed location")
                                }
                            }
                        }
                    } else {
                        Intent(context, LocationService::class.java).apply {
                            action = LocationService.ACTION_STOP
                            context.startService(this)


                        }
                        ApiManger.getapiservices().clockout(getToken(context)).enqueue(object :retrofit2.Callback<ClockoutResponse>{
                            override fun onResponse(
                                p0: Call<ClockoutResponse>,
                                p1: Response<ClockoutResponse>
                            ) {
                                val body = p1.body()
                                if (p1.isSuccessful && body != null) {
                                    Log.e(
                                        "tag",
                                        "onResponse: clockout, message: ${body.message}"
                                    )
                                    Log.e(
                                        "tag",
                                        "onResponse: clockout, record: ${body.record}"
                                    )

                                }

                            }

                            override fun onFailure(p0: Call<ClockoutResponse>, p1: Throwable) {
                                Log.e(
                                    "tag",
                                    "onResponse: clockout not work ,"
                                )

                            }
                        })


                        myState.value = "CLOCK IN"
                        brushColorIndex.value = 0
                    }
                }
        ) {
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.click_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .size(114.dp), tint = Color.White
                )
                Text(text = myState.value, modifier = Modifier.padding(top = 12.dp), color = Color.White, fontSize = 22.sp)
            }
        }
        Text(
            text = "Location : Faculty of Science",
            modifier = Modifier.padding(top = 40.dp),
            fontSize = 18.sp,
            color = Color(0xFF1A1D21)
        )
        Row(
            modifier = Modifier
                .padding(top = 55.dp, start = 20.dp)
                .fillMaxWidth()
                .height(140.dp)
        ) {
            Column {
                Icon(
                    painter = painterResource(id = R.drawable.clockin_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .size(42.dp)
                        .padding(start = 14.dp), tint = bluecolour
                )
                Text(
                    text = " 09:10", Modifier
                        .padding(start = 5.dp), fontSize = 18.sp, color = Color(0xFF1A1D21)
                )
                Text(
                    text = "Clock in", fontSize = 18.sp, color = Color(0xFF1A1D21)
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.clockout_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .size(42.dp)
                        .padding(start = 14.dp), tint = bluecolour
                )
                Text(
                    text = " 03:10", Modifier
                        .padding(start = 5.dp), fontSize = 18.sp, color = Color(0xFF1A1D21)
                )
                Text(
                    text = "Clock Out", fontSize = 18.sp, color = Color(0xFF1A1D21)
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.workinghour_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .size(42.dp)
                        .padding(start = 17.dp), tint = bluecolour
                )
                Text(
                    text = " 06:10", Modifier
                        .padding(start = 5.dp), fontSize = 18.sp, color = Color(0xFF1A1D21)
                )
                Text(
                    text = "Work Hrs", fontSize = 18.sp, color = Color(0xFF1A1D21)
                )
            }
        }
    }
}

private fun isLocationInsideCircle(lat: Double, long: Double, centerLat: Double, centerLong: Double, radius: Double): Boolean {
    val results = FloatArray(1)
    android.location.Location.distanceBetween(centerLat, centerLong, lat, long, results)
    return results[0] <= radius
}

private fun showToast(context: Context, message: String) {
    val mainHandler = Handler(context.mainLooper)
    mainHandler.post {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}

@Composable
@Preview
fun clockinpreview() {
    clockin(context = AppCompatActivity())
}
