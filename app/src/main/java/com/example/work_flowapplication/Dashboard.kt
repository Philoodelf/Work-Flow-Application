package com.example.work_flowapplication


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.work_flowapplication.ui.theme.SecondScreen
import com.example.work_flowapplication.ui.theme.graycolour

@Composable
fun Dashboard( modifier: Modifier = Modifier,navHostController: NavHostController) {


    Column (modifier.background(graycolour)){

        Box(modifier = Modifier.padding(start = 9.dp, top = 9.dp)) {
            Piechart(
                data = mapOf(
                    Pair("Present ", 41),
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
                .padding(start = 20.dp, end = 20.dp , top = 15.dp)
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
                                navHostController.navigate(SecondScreen.Timetrack.route)
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
                                // navController.navigate("SendAlert")
                                navHostController.navigate(SecondScreen.SendAlert.route)
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
                                navHostController.navigate(SecondScreen.CreateTask.route)
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
                            .clickable {
                                navHostController.navigate(SecondScreen.location.route)
                            },
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
                                navHostController.navigate(SecondScreen.Search.route)
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
                                navHostController.navigate(SecondScreen.Addemployee.route)
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