package com.example.work_flowapplication


import android.widget.Toast
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dashboard() {
//    Box(modifier = Modifier.fillMaxSize()){
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ) {
//        //    Text(text = "Dashboard", fontSize = 30.sp)
//        }
//    }
    Column {

    Box(modifier = Modifier.padding(start = 9.dp, top = 9.dp)) {
        Piechart(
            data = mapOf(
                Pair("Present ", 40),
                Pair("Vacation ", 23),
                Pair("Absent ", 35),
            )
        )
    }

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 390.dp, height = 620.dp)
                .padding(start = 35.dp, end = 20.dp)
            , shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color(0xFFE5E4E2))
        ){
            Column(
                modifier = Modifier.padding(4.dp), // Apply padding to the entire column
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    //inner cards
                    //small card
                    ElevatedCard(elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                        modifier = Modifier
                            .size(width = 140.dp, height = 120.dp)
                            .padding(8.dp)
                            .clickable {
                                /*to do */
                            },
                        colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Column( horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 15.dp, top = 5.dp)) {
                           Image(
                               painter = painterResource(id = R.drawable.timetrack), contentDescription =null,
                               modifier = Modifier.size(65.dp),


                           )
                            Text("Time Track", fontSize = 16.sp, color = Color.Black)
                        }

                    }
                    //second
                    ElevatedCard(elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                        modifier = Modifier
                            .size(width = 140.dp, height = 120.dp)
                            .padding(8.dp)
                            .clickable {
                                /*to do */
                            },
                        colors = CardDefaults.cardColors(Color.White)
                    ) {

                        Column( horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 20.dp, top = 5.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.sentalert), contentDescription =null,
                                modifier = Modifier.size(65.dp),


                                )
                            Text("Send Alert", fontSize = 16.sp, color = Color.Black)
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    //third
                    ElevatedCard(elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                        modifier = Modifier
                            .size(width = 140.dp, height = 120.dp)
                            .padding(8.dp)
                            .clickable {
                                /*to do */
                            },
                        colors = CardDefaults.cardColors(Color.White)
                    ) {

                        Column( horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 30.dp, top = 8.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.task), contentDescription =null,
                                modifier = Modifier.size(65.dp),


                                )
                            Text("Task", fontSize = 16.sp, color = Color.Black)
                        }
                    }
                    //fourth

                    ElevatedCard(elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                        modifier = Modifier
                            .size(width = 140.dp, height = 120.dp)
                            .padding(8.dp)
                            .clickable {/*to do */ },
                        colors = CardDefaults.cardColors(Color.White)
                    ) {

                        Column( horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 30.dp, top = 5.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.gps), contentDescription =null,
                                modifier = Modifier.size(65.dp),


                                )
                            Text("Gps", fontSize = 16.sp, color = Color.Black)
                        }
                    }

                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    //fifth
                    ElevatedCard(elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                        modifier = Modifier
                            .size(width = 140.dp, height = 120.dp)
                            .padding(8.dp)
                            .clickable {
                                /*to do */
                            },
                        colors = CardDefaults.cardColors(Color.White)
                    ) {

                        Column( horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 5.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.editemployee), contentDescription =null,
                                modifier = Modifier.size(65.dp),


                                )
                            Text("Edit Employee", fontSize = 16.sp, color = Color.Black)
                        }
                    }
                    //sixth
                    ElevatedCard(elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                        modifier = Modifier
                            .size(width = 140.dp, height = 120.dp)
                            .padding(8.dp)
                            .clickable {
                                /*to do */
                            },
                        colors = CardDefaults.cardColors(Color.White)
                    ) {

                        Column( horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 5.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.addemployee), contentDescription =null,
                                modifier = Modifier.size(65.dp),


                                )
                            Text("Add Employee", fontSize = 16.sp, color = Color.Black)
                        }
                    }

                }

            }
        }

    }
}



