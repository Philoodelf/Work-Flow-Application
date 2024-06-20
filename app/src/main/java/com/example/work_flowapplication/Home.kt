package com.example.work_flowapplication

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joelkanyi.horizontalcalendar.HorizontalCalendarView
import kotlin.math.abs

@SuppressLint("SuspiciousIndentation")
@Composable
fun Home() {
    var title: String
    title = Screens.Home.route.toString()
    val context = LocalContext.current.applicationContext

    val present = remember { mutableStateOf((5..20).random()) }
    val late = remember { mutableStateOf((1..7).random()) }
    val early = remember { mutableStateOf((1..5).random()) }
    val absent = remember { mutableStateOf((1..5).random()) }
    val vacation = remember { mutableStateOf((1..5).random()) }
    val deadline = remember { mutableStateOf((1..5).random()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalCalendarView(
            modifier = Modifier.border(1.dp, Color.Gray, shape = RoundedCornerShape(16.dp)),
            selectedTextColor = Color.White,
            unSelectedTextColor = Color.Black,
            selectedCardColor = Color(0xFF029DF0),
            unSelectedCardColor = Color.White,
            onDayClick = { day ->
              //  Toast.makeText(context, day.toString(), Toast.LENGTH_SHORT).show()
                present.value = (5..20).random()
                late.value = (1..7).random()
                early.value = (1..5).random()
                absent.value = (1..5).random()
                vacation.value = (1..5).random()
                deadline.value = (1..5).random()
            })
        //big card
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 350.dp, height = 620.dp)
                .padding(top = 15.dp)
            //.padding(vertical = 4.dp)
            , shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color.White)


        ) {
            Text(
                text = "Today Attendance",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )




            Column(
                modifier = Modifier.padding(16.dp), // Apply padding to the entire column
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    //inner cards
                    //small card
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .size(width = 160.dp, height = 120.dp)
                            .padding(12.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "${present.value} Are present", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        colors = CardDefaults.cardColors(Color(0xFFE0EBF4))
                    ) {
                        Column {
                            Text("Present", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                            Text(present.value.toString(), fontSize = 25.sp, color = Color(0xFF45A6F5))
                        }

                    }
                    //second
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .size(width = 160.dp, height = 120.dp)
                            .padding(12.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "${late.value} Came Late", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        colors = CardDefaults.cardColors(Color(0xFFF5EBD7))
                    ) {

                        Column {
                            Text("Late In", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                            Text(late.value.toString(), fontSize = 25.sp, color = Color(0xFFF09E07))
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    //third
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .size(width = 160.dp, height = 120.dp)
                            .padding(12.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "${early.value} Have left early", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        colors = CardDefaults.cardColors(Color(0xFFA7D5C9))
                    ) {

                        Column {
                            Text("Early Leave", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                            Text(early.value.toString(), fontSize = 25.sp, color = Color(0xFF05B279))
                        }
                    }
                    //fourth

                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .size(width = 160.dp, height = 120.dp)
                            .padding(12.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "${absent.value} Are Absents", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        colors = CardDefaults.cardColors(Color(0xFFED9BA4))
                    ) {

                        Column {
                            Text("Absents", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                            Text(absent.value.toString(), fontSize = 25.sp, color = Color(0xFFF75262))
                        }
                    }

                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    //fifth
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .size(width = 160.dp, height = 120.dp)
                            .padding(12.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "${vacation.value} Are on a Vacation", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        colors = CardDefaults.cardColors(Color(0xFFE5E5F5))
                    ) {

                        Column {
                            Text("Vacation", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                            Text(vacation.value.toString(), fontSize = 25.sp, color = Color(0xFFAEAEE0))
                        }
                    }
                    //sixth
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .size(width = 160.dp, height = 120.dp)
                            .padding(12.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "${deadline.value} Deadline Task", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        colors = CardDefaults.cardColors(Color(0xFFF6E5DE))
                    ) {

                        Column {
                            Text(
                                "Deadline Task",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(deadline.value.toString(), fontSize = 25.sp, color = Color(0xFFE6B6A2))
                        }
                    }

                }

            }
        }

    }


}
