package com.example.work_flowapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calender(navController: NavHostController) {

Box(modifier =  Modifier.fillMaxSize().background(graycolour))
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.55f).clip(RoundedCornerShape(25.dp))
            ,
        colors = CardDefaults.cardColors(white),
        elevation = CardDefaults.cardElevation(15.dp)

    )
     {
        val dateState = rememberDatePickerState()
        DatePicker(
            state = dateState ,
     colors =DatePickerDefaults.colors(
         todayContentColor = red,
         selectedDayContainerColor = bluecolour,
         dayContentColor = black

     ),


        )



    }
}

/*
AndroidView(factory = {CalendarView(it)},   update = { view ->
    val calendarView = view as CalendarView

    calendarView.setBackgroundColor(0xFFF5F6FA.toInt())



    })*/}













