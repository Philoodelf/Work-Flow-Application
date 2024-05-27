package com.example.work_flowapplication



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Report() {
    Box(Modifier.background(Color.White)) {
//    Box(modifier = Modifier.fillMaxSize()){
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ) {
//          //  Text(text = "Report", fontSize = 30.sp)
//        }
//    }
    Column {
        //first card
        Row {
            Image(
                painter = painterResource(id = R.drawable.reportprofile),
                contentDescription = "des",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(start = 15.dp, top = 15.dp)
            )
            Column(modifier = Modifier.padding(15.dp)) {
                Text(text = "Jane Hawkins", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "Front-End Developer", fontSize = 15.sp)
            }
        }
        //Second card
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 410.dp, height = 150.dp)
                .padding(start = 8.dp, top = 18.dp, end = 8.dp)
                .clickable {
                    /*to do */
                },
            colors = CardDefaults.cardColors(Color.White)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {

                //all tasks
                Column(
                    modifier = Modifier
                    //.padding(vertical = 15.dp)
                    , Arrangement.Center

                ) {
                    Text(
                        text = "30 Tasks",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .padding(
                                top = 20.dp,
                                end = 10.dp,
                                start = 10.dp,
                                bottom = 10.dp
                            )
                    ) {
                        Piechartonly(
                            data = mapOf(
                                Pair("A", 15),
                                Pair("B", 12),
                                Pair("C", 3),
                            )
                        )
                    }

                }
                // completed second
                Column(
                    modifier = Modifier.padding(top = 8.dp), Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .padding(top = 30.dp, start = 20.dp)
                    ) {


                        Piechartonly(
                            data = mapOf(
                                Pair("A", 15),
                                Pair("B", 12),
                                Pair("C", 3),
                            )
                        )


                    }

                    Text(
                        text = "15 Completed",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF956CE6),
                        modifier = Modifier
                            .padding(top = 15.dp)
                    )
                }

                //third incomplete
                Column(
                    modifier = Modifier.padding(top = 8.dp), Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .padding(top = 30.dp, start = 20.dp)
                    ) {


                        Piechartonly(
                            data = mapOf(
                                Pair("A", 15),
                                Pair("B", 12),
                                Pair("C", 3),
                            )
                        )


                    }

                    Text(
                        text = "12 Incomplete",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFBF41),
                        modifier = Modifier
                            .padding(top = 15.dp, start = 6.dp)
                    )
                }

                // left forth
                Column(
                    modifier = Modifier.padding(top = 8.dp), Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .padding(top = 30.dp, start = 20.dp)
                    ) {


                        Piechartonly(
                            data = mapOf(
                                Pair("A", 15),
                                Pair("B", 12),
                                Pair("C", 3),
                            )
                        )


                    }

                    Text(
                        text = "3 Left",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF4948),
                        modifier = Modifier
                            .padding(top = 15.dp, start = 18.dp)
                    )
                }

            }

        }

        //third card
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 410.dp, height = 600.dp)
                .padding(top = 18.dp)
                .clickable {
                    /*to do */
                },
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Text(
                text = "Attendance",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Box(modifier = Modifier.padding(start = 12.dp, top = 9.dp )) {
                Piechart(
                    data = mapOf(
                        Pair("Present ", 52),
                        Pair("Vacation ", 25),
                        Pair("Absent ", 8),
                    )
                )
            }

        }


    }
    }
}
