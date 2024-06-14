package com.example.work_flowapplication.ui.location

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.work_flowapplication.ui.localdata.saveCirclePosition
import com.example.work_flowapplication.ui.theme.bluecolour
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import java.lang.Math.cos
import java.lang.Math.sin


@Composable
fun location(navController: NavHostController) {
    val atasehir = LatLng(31.205753, 29.924526)

    val context = LocalContext.current.applicationContext

    val cameraPositionState= rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(atasehir, 15f)
    }

    var uisettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
    }
var  properties by remember {
    mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
}
    var markerPosition by remember {
        mutableStateOf<LatLng?>(null)
    }
    fun getCirclePoints(center: LatLng, radius: Double, numPoints: Int): List<LatLng> {
        val points = mutableListOf<LatLng>()
        val angleStep = 2 * Math.PI / numPoints
        val correctionFactor = cos(Math.toRadians(center.latitude))
        for (i in 0 until numPoints) {
            val angle = i * angleStep
            val lat = center.latitude + radius * cos(angle)
            val lng = center.longitude + radius * sin(angle) / correctionFactor
            points.add(LatLng(lat, lng))

        }
        return points
    }

    GoogleMap (
        modifier = Modifier.fillMaxSize()
        ,
        cameraPositionState = cameraPositionState,
                properties = properties,
        uiSettings = uisettings,
                onMapClick = { latLng ->
            markerPosition = latLng
        }



    ) {
        markerPosition?.let { position ->
            Marker(
                state = MarkerState(position = position),
                title = "marker1",
            )
            val radius = 0.0005 // Adjust this value to change the radius of the circle
            val circlePoints = getCirclePoints(position, radius, 100)
            val squareSideLength = 0.0005   // Adjust this value to change the size of the square


            Circle(
                center = position,
                radius = 150.0, // Radius in meters
                fillColor = bluecolour.copy(0.5f), // ARGB color for 50% transparent green
                strokeColor = bluecolour, // ARGB color for solid green
                strokeWidth = 2f
            )
            Log.e("tag", "circilepoint , point: ${position}")
        }


    }
    FloatingActionButton(onClick = {
        markerPosition?.let { position ->
            saveCirclePosition(context, position.latitude, position.longitude, 500.0) // Example radius 500 meters

    }}){
        Icon(imageVector = Icons.Default.Save, contentDescription = "Save Position")
    }

 }