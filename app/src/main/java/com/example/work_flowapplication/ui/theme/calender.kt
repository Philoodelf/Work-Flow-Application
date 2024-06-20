package com.example.work_flowapplication.ui.theme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.SubdirectoryArrowLeft
import androidx.compose.material.icons.filled.SubdirectoryArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calender(navController: NavHostController) {






    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(graycolour)
    )
    {
        Column {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color(0xFF029DF0),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 32.dp, top = 16.dp)
                    .size(25.dp)
                    .clickable {
                        navController.popBackStack()
                    })
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.55f)
                    .clip(RoundedCornerShape(25.dp)),
                colors = CardDefaults.cardColors(white),
                elevation = CardDefaults.cardElevation(15.dp)

            )
            {
                val dateState = rememberDatePickerState()
                DatePicker(
                    state = dateState,
                    colors = DatePickerDefaults.colors(
                        todayContentColor = red,
                        selectedDayContainerColor = bluecolour,
                        dayContentColor = black

                    ),


                    )


            }

            //first card

            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .padding(start = 20.dp, top = 16.dp)
                    .clickable { "to do" },
                colors = CardDefaults.cardColors(Color.White)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Icon(
                        imageVector = Icons.Default.SubdirectoryArrowRight,
                        contentDescription = "",
                        modifier = Modifier.padding(start = 20.dp, top = 16.dp)

                    )
                    Text(
                        text = "Login At: ",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                    Text(
                        text = "8:00:00 AM ",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )

                }
            }


            //second card
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .padding(start = 20.dp, top = 16.dp)
                    .clickable { "to do" },
                colors = CardDefaults.cardColors(Color.White)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Icon(
                        imageVector = Icons.Default.SubdirectoryArrowLeft,
                        contentDescription = "",
                        modifier = Modifier.padding(start = 20.dp, top = 16.dp)

                    )
                    Text(
                        text = "Logout At: ",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                    Text(
                        text = "4:00:00 PM ",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )

                }
            }

            // third card
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .padding(start = 20.dp, top = 16.dp)
                    .clickable { "to do" },
                colors = CardDefaults.cardColors(Color.White)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = "",
                        modifier = Modifier.padding(start = 20.dp, top = 16.dp)

                    )
                    Text(
                        text = "Total Hours: ",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                    Text(
                        text = " 8 Hours ",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )

                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Aligns children to the end (right side)
            ) {
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .width(220.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(1.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(
                        text = "GET Record",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }


            }




        }





/*
AndroidView(factory = {CalendarView(it)},   update = { view ->
    val calendarView = view as CalendarView

    calendarView.setBackgroundColor(0xFFF5F6FA.toInt())



    })*/
